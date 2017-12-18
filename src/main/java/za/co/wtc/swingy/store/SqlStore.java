package za.co.wtc.swingy.store;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.artifact.ArtifactType;
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
	private static final String DB_URL = "jdbc:mysql://localhost/swingy?useSSL=false";

	private static final String USER = "java";
	private static final String PASS = "javaPass";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			Properties prop = new Properties();
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (ClassNotFoundException | InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int addArtifact(Connection con, Artifact artifact) throws SQLException {
		PreparedStatement stmtArtifact = null;
		Statement getId = null;
		String insertHero = "INSERT INTO swingy.ARTIFACT (value, max_value, type) VALUES (?,?,?)";
		String lastInsert = "SELECT LAST_INSERT_ID() AS id;";
		try {
			stmtArtifact = con.prepareStatement(insertHero);
			stmtArtifact.setInt(1, artifact.getValue());
			stmtArtifact.setInt(2, artifact.getMaxValue());
			stmtArtifact.setString(3, artifact.getType().toString());
			getId = con.createStatement();
			stmtArtifact.executeUpdate();
			ResultSet idRs = getId.executeQuery(lastInsert);
			if (idRs.next())
				return idRs.getInt("id");

		} catch (SQLException e) {
			System.err.println("Data base failure.");
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (stmtArtifact != null) {
				stmtArtifact.close();
			}
		}
		return -1;
	}

	public static Artifact getArtifact(Connection con, int artifactID)
			throws SQLException {
		PreparedStatement stmt = null;
		String query = "SELECT * FROM swingy.ARTIFACT WHERE ID = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, artifactID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String type = rs.getString("type");
				int value = rs.getInt("value");
				int max = rs.getInt("max_value");
				int id = rs.getInt("id");
				return new Artifact(ArtifactType.valueOf(type),value, max, id);
			}
		} catch (SQLException e) {
			System.err.println("Data base failure.");
			e.printStackTrace();
			System.exit(1);

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return null;
	}

	public static void updateArtifact(Connection con, Artifact artifact) throws SQLException {
		PreparedStatement stmt = null;
		String query = "UPDATE swingy.ARTIFACT SET value = ?, max_value = ?, type = ? WHERE id = ?;";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, artifact.getValue());
			stmt.setInt(2, artifact.getMaxValue());
			stmt.setString(3, artifact.getType().toString());
			stmt.setInt(4, artifact.getId());
			stmt.executeUpdate();
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

	private static  Hero passHero(ResultSet rs, Connection con) throws SQLException {
		Artifact weapon = null;
		Artifact armor = null;
		Artifact helm = null;
		if (rs.getObject("weapon") != null){

			weapon = getArtifact(con, rs.getInt("weapon"));
		}
		if (rs.getObject("armor") != null){
			armor = getArtifact(con, rs.getInt("armor"));
		}
		if (rs.getObject("helm") != null){
			helm = getArtifact(con, rs.getInt("helm"));
		}
		return (CharicterFactory.creatHero(CharacterType.valueOf(rs.getString("type")),
				rs.getString("name"),
				rs.getInt("level"),
				rs.getInt("experience"),
				rs.getInt("attack"),
				rs.getInt("defence"),
				rs.getInt("hit_points"),
				weapon, armor, helm,
				rs.getInt("id")));
	}

	public static List<Hero> listHerose(Connection con) throws SQLException {

		List<Hero> re = new ArrayList<>();
		Statement stmt = null;
		String query = "SELECT * FROM HEROS";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				re.add(passHero(rs, con));
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
			stmtHero.executeUpdate();
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
			if (rs.next())  {
				re = passHero(rs, con);
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
				updateArtifact(con, hero.getWeapon());
			} else {
				stmt.setObject(6, null);
			}
			if (hero.getArmor() != null) {
				stmt.setInt(7, hero.getArmor().getId());
				updateArtifact(con, hero.getArmor());
			} else {
				stmt.setObject(7, null);
			}
			if (hero.getHelmet() != null) {
				stmt.setInt(8, hero.getHelmet().getId());
				updateArtifact(con, hero.getHelmet());
			} else {
				stmt.setObject(8, null);
			}
			stmt.setLong(9, hero.getID());
			stmt.executeUpdate();
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
