package za.co.wtc.swingy.controller.gui;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.view.gui.GameGUI;
import za.co.wtc.swingy.view.gui.HeroCreateGUI;
import za.co.wtc.swingy.view.gui.HeroSelectGUI;
import za.co.wtc.swingy.view.gui.LoadCreateGUI;

public class WindowController {
	private static WindowController incetance = null;
	private GameControllerGUI gameController = null;
	private HeroCreateControllerGUI createController = null;
	private HeroSelectControllerGUI selectController = null;
	private LoadCreateControllerGUI loadCreateController = null;


	private WindowController() {
		GameGUI game = new GameGUI();
		HeroCreateGUI heroCreate = new HeroCreateGUI();
		HeroSelectGUI heroSelect = new HeroSelectGUI();
		LoadCreateGUI loadCreate = new LoadCreateGUI();
		gameController = new GameControllerGUI(new GameModel(null), game);
		createController = new HeroCreateControllerGUI(heroCreate);
		selectController = new HeroSelectControllerGUI(heroSelect);
		loadCreateController = new LoadCreateControllerGUI(loadCreate);
	}

	public static WindowController getIncetance() {
		if (incetance == null) {
			synchronized (WindowController.class) {
				incetance = new WindowController();
			}
		}
		return incetance;
	}

	public GameControllerGUI getGameController() {
		return gameController;
	}

	public HeroCreateControllerGUI getCreateController() {
		return createController;
	}

	public HeroSelectControllerGUI getSelectController() {
		return selectController;
	}

	public LoadCreateControllerGUI getLoadCreateController() {
		return loadCreateController;
	}

	/*public GameGUI getGame() {
		return game;
	}

	public HeroCreateGUI getHeroCreate() {
		return heroCreate;
	}

	public HeroSelectGUI getHeroSelect() {
		return heroSelect;
	}

	public LoadCreateGUI getLoadCreate() {
		return loadCreate;
	}*/
}
