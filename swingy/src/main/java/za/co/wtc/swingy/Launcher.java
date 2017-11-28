package za.co.wtc.swingy;

import za.co.wtc.swingy.controller.GameController;
import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.view.GameCLI;

public class Launcher {
	public static void main(String[] args) {
		GameCLI view = new GameCLI();
		Hero hero = new Hero("Roo", "Heavy", 0, 0, 10, 5, 100);
		GameModel model = new GameModel(hero);
		System.out.println(hero);
		GameController gameController = new GameController(view, model);

		gameController.runGame();
		hero = gameController.getHero();
		System.out.println(hero);
	}
}
