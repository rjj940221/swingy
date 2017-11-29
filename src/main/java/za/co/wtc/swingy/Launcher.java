package za.co.wtc.swingy;

import za.co.wtc.swingy.controller.GameController;
import za.co.wtc.swingy.controller.HeroSelectorController;
import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.charicters.CharacterType;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.GameCLI;
import za.co.wtc.swingy.view.HeroSelectCLI;
import za.co.wtc.swingy.view.LoadCreatCLI;
import za.co.wtc.swingy.view.LoadCreatView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Launcher {
	public static void main(String[] args) {
		try {
			Connection con = SqlStore.getConnection();
			List<Hero> herose = SqlStore.listHerose(con);
			Hero hero = null;
			boolean creat = true;
			if (!herose.isEmpty()) {
				LoadCreatView loadCreat = new LoadCreatCLI();
				creat = loadCreat.loadOrCreate();
			}
			if (creat) {
				//todo: gethero from create controller
				hero = new Hero("Roo", CharacterType.HUMAN,0,0,10,2,20);
			} else {
				hero = new HeroSelectorController(new HeroSelectCLI(), herose).selectHero();
			}
			if (hero == null)
			{
				System.err.print("Failed to load hero");
				System.exit(1);
			}
			System.out.println(hero);
			GameController gameController = new GameController(new GameCLI(), new GameModel(hero));
			gameController.runGame();
		} catch (SQLException e) {
			System.err.println("Database crash");
		}

	}
}
