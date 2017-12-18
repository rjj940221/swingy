package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.GameModel;

public class ModelController {
	private static ModelController ourInstance = null;
	private GameModel gameModel;

	public static ModelController getInstance() {
		if (ourInstance == null){
			synchronized (ModelController.class){
				ourInstance = new ModelController();
			}
		}
		return ourInstance;
	}

	private ModelController() {
		gameModel = new GameModel(null);
	}

	public GameModel getGame(){
		return gameModel;
	}
}
