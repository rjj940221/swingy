package za.co.wtc.swingy;

import za.co.wtc.swingy.controller.HeroCreateControllerCLI;
import za.co.wtc.swingy.controller.HeroSelectorControllerCLI;
import za.co.wtc.swingy.controller.LoadCreateControllerCLI;
import za.co.wtc.swingy.controller.WindowController;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.HeroCreateCLI;
import za.co.wtc.swingy.view.HeroSelectCLI;
import za.co.wtc.swingy.view.LoadCreateCLI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Launcher {


	private static void cli() throws SQLException {
		try {
			Connection con = SqlStore.getConnection();
			List<Hero> heroes = SqlStore.listHerose(con);
			if (con != null) {
				con.close();
			}
			Hero hero;
			boolean create = true;
			if (!heroes.isEmpty()) {
				LoadCreateControllerCLI loadCreate = new LoadCreateControllerCLI(new LoadCreateCLI());
				create = loadCreate.create();
			}
			if (create) {
				hero = new HeroCreateControllerCLI(new HeroCreateCLI()).getNewHero();
				int id = SqlStore.addHero(con, hero);
				hero.setId(id);
			} else {
				hero = new HeroSelectorControllerCLI(new HeroSelectCLI(), heroes).selectHero();
			}
			if (hero == null) {
				System.err.print("Failed to load hero");
				System.exit(1);
			}
			WindowController.getIncetance().getGameControllerCLI().runGame(hero);
		} catch (SQLException e) {
			System.err.println("Database crash");
		}
	}

	private static void gui() throws SQLException {
		Connection con = null;
		try {
			con = SqlStore.getConnection();
			List<Hero> heroes = SqlStore.listHerose(con);
			if (!heroes.isEmpty()) {
				WindowController.getIncetance().getLoadCreateController().displayWindow();
			}else {
				WindowController.getIncetance().getCreateController().displayWindow();
			}
		} catch (SQLException e) {
			System.err.println("Database crash");
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			try {
				if (args[0].equalsIgnoreCase("console")) {

					cli();

				} else if (args[0].equalsIgnoreCase("gui")) {
					gui();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("argument not correctly specified expecting 'gui' or 'console'");
		}

	}
}
