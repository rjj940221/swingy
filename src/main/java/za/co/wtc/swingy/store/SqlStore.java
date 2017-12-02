package za.co.wtc.swingy.store;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.artifact.Weapon;
import za.co.wtc.swingy.modle.charicters.CharacterType;
import za.co.wtc.swingy.modle.charicters.CharicterFactory;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.modle.charicters.Human;

import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlStore {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/swingy";

	private static final String USER = "java";
	private static final String PASS = "javaPass";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to database");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Artifact selectArtifact(Connection con, int artifactID)
			throws SQLException {

		PreparedStatement stmt = null;
		String query = "SELECT * FROM ARTEFACTS WHERE ID = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, artifactID);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				String type = "";
				int value = 0;
				int max = 0;
				switch (type) {
					case "WEAPON":
						return new Weapon(value, max);
				}
			}
		} catch (SQLException e) {
			System.err.println("Data base failure.");
			System.exit(1);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return null;
	}


	public static List<Hero> listHerose(Connection con) throws SQLException {

		List<Hero> re = new ArrayList<>();
		Statement stmt = null;
		String query = "SELECT * FROM HEROS";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				re.add(CharicterFactory.creatHero(CharacterType.valueOf(rs.getString("type")),
						rs.getString("name"),
						rs.getInt("level"),
						rs.getInt("experience"),
						rs.getInt("attack"),
						rs.getInt("defence"),
						rs.getInt("hit_points"),
						null, null, null,
						rs.getInt("id")));
			}
		} catch (SQLException e) {
			System.err.println("Data base failure.");
			System.exit(1);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return re;
	}

	public static int addHero(Connection con, Hero hero) throws SQLException {
		PreparedStatement stmtHero = null;
		Statement getId = null;
		String insertHero = "INSERT INTO swingy.HEROS (name, type, level, experience, attack, defence, hit_points) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		String lastInsert = "SELECT LAST_INSERT_ID() AS id;";
		try {
			stmtHero = con.prepareStatement(insertHero);
			stmtHero.setString(1, hero.getName());
			stmtHero.setString(2, hero.getType().toString());
			stmtHero.setInt(3, hero.getLevel());
			stmtHero.setInt(4, (int) hero.getExperience());
			stmtHero.setInt(5, hero.getAttack());
			stmtHero.setInt(6, hero.getDefense());
			stmtHero.setInt(7, hero.getHitPoints());
			getId = con.createStatement();
			System.out.println(stmtHero.toString());
			int insert = stmtHero.executeUpdate();
			System.out.println(insert + " row's");
			ResultSet idRs = getId.executeQuery(lastInsert);
			if (idRs.next())
				return idRs.getInt("id");

		} catch (SQLException e) {
			System.err.println("Data base failure.");
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (stmtHero != null) {
				stmtHero.close();
			}
		}
		return -1;
	}

	public static Hero getHero(Connection con, long id) throws SQLException {
		Hero re = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM HEROS WHERE id = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, (int) id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				re = CharicterFactory.creatHero(CharacterType.valueOf(rs.getString("type")),
						rs.getString("name"),
						rs.getInt("level"),
						rs.getInt("experience"),
						rs.getInt("attack"),
						rs.getInt("defence"),
						rs.getInt("hit_points"),
						null, null, null,
						rs.getInt("id"));
			}
		} catch (SQLException e) {
			System.err.println("Data base failure.");
			System.exit(1);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return re;
	}

	public static void updateHero(Connection con, Hero hero) throws SQLException {
		PreparedStatement stmt = null;
		String query = "UPDATE swingy.HEROS SET level = ?, experience = ?, attack = ?, defence = ?, hit_points = ?, weapon = ?, armor = ?, helm = ? WHERE id = ?;";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, hero.getLevel());
			stmt.setLong(2, hero.getExperience());
			stmt.setInt(3, hero.getAttack());
			stmt.setInt(4, hero.getDefense());
			stmt.setInt(5, hero.getHitPoints());
			if (hero.getWeapon() != null) {
				stmt.setInt(6, hero.getWeapon().getId());
			} else {
				stmt.setObject(6, null);
			}
			if (hero.getArmor() != null) {
				stmt.setInt(7, hero.getArmor().getId());
			} else {
				stmt.setObject(7, null);
			}
			if (hero.getHelmet() != null) {
				stmt.setInt(8, hero.getHelmet().getId());
			} else {
				stmt.setObject(8, null);
			}
			stmt.setLong(9, hero.getID());
			int rs = stmt.executeUpdate();
			System.out.println(rs + " rows affected");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Data base failure.");
			System.exit(1);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
