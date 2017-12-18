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
			WindowController.getIncetance().setGui(false);
			Connection con = SqlStore.getConnection();
			List<Hero> heroes = SqlStore.listHerose(con);

			Hero hero;
			boolean create = true;
			if (!heroes.isEmpty()) {

				create = WindowController.getIncetance().getLoadCreateControllerCLI().create();
			}
			if (create) {
				hero = WindowController.getIncetance().getHeroCreateControllerCLI().getNewHero();
				int id = SqlStore.addHero(con, hero);
				hero.setId(id);
			} else {
				hero = WindowController.getIncetance().getHeroSelectorControllerCLI().selectHero();
			}
			if (con != null) {
				con.close();
			}
			if (hero == null) {
				System.err.print("Failed to load hero");
				System.exit(1);
			}
			WindowController.getIncetance().getGameControllerCLI().runGame(hero);

		} catch (SQLException e) {
			System.err.println("Database crash");
			System.exit(1);
		}
	}

	private static void gui() throws SQLException {
		Connection con = null;
		try {
			WindowController.getIncetance().setGui(true);
			con = SqlStore.getConnection();
			List<Hero> heroes = SqlStore.listHerose(con);
			if (!heroes.isEmpty()) {
				WindowController.getIncetance().getLoadCreateController().displayWindow();
			} else {
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
				}else{
					System.out.println("arg [" + args[0]+"] not recognised expecting 'gui' or 'console'");
					System.exit(1);
				}
				while (true) {
					if (!WindowController.getIncetance().isGui()) {
						WindowController.getIncetance().getGameControllerCLI().displayMenu();
					}else {
						Thread.sleep(10);
					}
				}
			} catch (SQLException | InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("argument not correctly specified expecting 'gui' or 'console'");
		}

	}
}
