package za.co.wtc.swingy.store;

import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.artifact.Weapon;
import za.co.wtc.swingy.modle.charicters.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlStore {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
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

	public static Artifact selectHerose(Connection con, int artifactID)
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

	public static void addHero(Connection con, Hero hero) throws SQLException {
		PreparedStatement stmt = null;
		String query = "INSERT INTO HERO (name, level, experience) VALUES (?, ?, ?)";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, hero.getName());
			ResultSet rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			System.err.println("Data base failure.");
			System.exit(1);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public static void updateHero(Connection con, Hero hero) throws SQLException {
		PreparedStatement stmt = null;
		String query = "UPDATE HERO SET name = '?', level = '?', experience = '?' WHERE id = '?'";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, hero.getName());
			stmt.setInt(2, hero.getLevel());
			stmt.setLong(3, hero.getExperience());
			stmt.setLong(4, hero.getID());
			ResultSet rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			System.err.println("Data base failure.");
			System.exit(1);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
