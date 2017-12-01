package za.co.wtc.swingy.controller.gui;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.view.gui.GameGUI;
import za.co.wtc.swingy.view.gui.HeroCreateGUI;
import za.co.wtc.swingy.view.gui.HeroSelectGUI;
import za.co.wtc.swingy.view.gui.LoadCreateGUI;

public class WindowController {
	public static WindowController incetance = null;
	private GameGUI game = null;
	private HeroCreateGUI heroCreate = null;
	private HeroSelectGUI heroSelect = null;
	private LoadCreateGUI loadCreate = null;

	private GameControllerGUI gameController = null;
	private HeroCreateControllerGUI createController = null;
	private HeroSelectControllerGUI selectController = null;
	private LoadCreateControllerGUI loadCreateController = null;


	private WindowController() {
		game = new GameGUI();
		heroCreate = new HeroCreateGUI();
		heroSelect = new HeroSelectGUI();
		loadCreate = new LoadCreateGUI();
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

	public GameGUI getGame() {
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
	}
}
