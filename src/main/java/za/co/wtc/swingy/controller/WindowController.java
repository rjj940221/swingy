package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.view.GameCLI;
import za.co.wtc.swingy.view.HeroCreateCLI;
import za.co.wtc.swingy.view.HeroSelectCLI;
import za.co.wtc.swingy.view.LoadCreateCLI;
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
	private HeroSelectorControllerCLI heroSelectorControllerCLI = null;
	private HeroCreateControllerCLI heroCreateControllerCLI = null;
	private LoadCreateControllerCLI loadCreateControllerCLI = null;
	private boolean gui = false;


	private WindowController() {
		HeroCreateGUI heroCreate = new HeroCreateGUI();
		HeroSelectGUI heroSelect = new HeroSelectGUI();
		LoadCreateGUI loadCreate = new LoadCreateGUI();
		gameControllerGUI = new GameControllerGUI(ModelController.getInstance().getGame(),  new GameGUI());
		createController = new HeroCreateControllerGUI(heroCreate);
		selectController = new HeroSelectControllerGUI(heroSelect);
		loadCreateController = new LoadCreateControllerGUI(loadCreate);
		gameControllerCLI  = new GameControllerCLI(new GameCLI(), ModelController.getInstance().getGame());
		heroSelectorControllerCLI = new HeroSelectorControllerCLI(new HeroSelectCLI());
		heroCreateControllerCLI = new HeroCreateControllerCLI(new HeroCreateCLI());
		loadCreateControllerCLI = new LoadCreateControllerCLI(new LoadCreateCLI());

	}

	public static WindowController getIncetance() {
		if (incetance == null) {
			synchronized (WindowController.class) {
				incetance = new WindowController();
			}
		}
		return incetance;
	}

	public boolean isGui() {
		return gui;
	}

	public void setGui(boolean gui) {
		this.gui = gui;
		System.out.println("Set gui mode to: "+ gui);
	}

	public LoadCreateControllerCLI getLoadCreateControllerCLI() {
		return loadCreateControllerCLI;
	}

	public HeroCreateControllerCLI getHeroCreateControllerCLI() {
		return heroCreateControllerCLI;
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

	public HeroSelectorControllerCLI getHeroSelectorControllerCLI() {
		return heroSelectorControllerCLI;
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
