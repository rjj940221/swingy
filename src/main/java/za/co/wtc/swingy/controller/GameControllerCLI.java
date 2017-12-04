package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.GameState;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.GameCLI;
import za.co.wtc.swingy.view.HeroCreateCLI;
import za.co.wtc.swingy.view.HeroSelectCLI;
import za.co.wtc.swingy.view.LoadCreateCLI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameControllerCLI {
	private GameCLI gameView;
	private GameModel gameModel;

	public GameControllerCLI(GameCLI gameView, GameModel gameModel) {
		this.gameView = gameView;
		this.gameModel = gameModel;
	}

	public void displayMenu() {
		Connection con;
		switch (gameView.displayMenu()) {
			case 0:
				runGame();
				break;
			case 1:
				WindowController.getIncetance().getGameControllerGUI().displayMenu();
				break;
			case 2:
				try {
					con = SqlStore.getConnection();
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
					runGame(hero);
				} catch (SQLException e) {
					System.err.println("Database crash");
				}

				break;
		}
	}


	public void runGame() {
		gameModel.setLevel();
		while (gameModel.getGameState() == GameState.InProgress) {
			if (gameModel.canMove()) {
				gameModel.moveHero(gameView.move());
			} else {
				if (gameView.fight(gameModel.getHero(), gameModel.getOponent())) {
					gameModel.fight();
					gameView.fightResult(gameModel.getHero(), gameModel.getOponent());
				} else {
					if (!gameModel.flee()) {
						gameModel.fight();
						gameView.fightResult(gameModel.getHero(), gameModel.getOponent());
					}
				}
			}
		}
		displayMenu();
	}

	public void runGame(Hero hero) {
		if (hero != null) {
			gameModel.setHero(hero);
			runGame();
		}
		displayMenu();
	}

	public Hero getHero() {
		return gameModel.getHero();
	}
}
