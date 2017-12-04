package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.view.GameCLI;
import za.co.wtc.swingy.view.gui.GameGUI;
import za.co.wtc.swingy.view.gui.HeroCreateGUI;
import za.co.wtc.swingy.view.gui.HeroSelectGUI;
import za.co.wtc.swingy.view.gui.LoadCreateGUI;

public class WindowController {
	private static WindowController incetance = null;
	private GameControllerGUI gameControllerGUI = null;
	private HeroCreateControllerGUI createController = null;
	private HeroSelectControllerGUI selectController = null;
	private LoadCreateControllerGUI loadCreateController = null;
	private GameControllerCLI gameControllerCLI = null;


	private WindowController() {
		HeroCreateGUI heroCreate = new HeroCreateGUI();
		HeroSelectGUI heroSelect = new HeroSelectGUI();
		LoadCreateGUI loadCreate = new LoadCreateGUI();
		gameControllerGUI = new GameControllerGUI(ModelController.getInstance().getGame(),  new GameGUI());
		createController = new HeroCreateControllerGUI(heroCreate);
		selectController = new HeroSelectControllerGUI(heroSelect);
		loadCreateController = new LoadCreateControllerGUI(loadCreate);
		gameControllerCLI  = new GameControllerCLI(new GameCLI(), ModelController.getInstance().getGame());
	}

	public static WindowController getIncetance() {
		if (incetance == null) {
			synchronized (WindowController.class) {
				incetance = new WindowController();
			}
		}
		return incetance;
	}

	public GameControllerGUI getGameControllerGUI() {
		return gameControllerGUI;
	}

	public GameControllerCLI getGameControllerCLI() {
		return gameControllerCLI;
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
