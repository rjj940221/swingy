package za.co.wtc.swingy;

import za.co.wtc.swingy.controller.*;
import za.co.wtc.swingy.controller.gui.LoadCreateControllerGUI;
import za.co.wtc.swingy.controller.gui.WindowController;
import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.*;
import za.co.wtc.swingy.view.gui.LoadCreateGUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Launcher {


	private static void cli() throws SQLException {
		Connection con = null;
		try {
			con = SqlStore.getConnection();
			List<Hero> heroes = SqlStore.listHerose(con);
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
			GameControllerCLI gameControllerCLI = new GameControllerCLI(new GameCLI(), new GameModel(hero));
			gameControllerCLI.runGame();
		} catch (SQLException e) {
			System.err.println("Database crash");
		} finally {
			if (con != null) {
				con.close();
			}
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
