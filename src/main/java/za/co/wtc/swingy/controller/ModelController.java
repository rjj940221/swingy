package za.co.wtc.swingy.controller;

public class ModelController {
	private static ModelController ourInstance = new ModelController();

	public static ModelController getInstance() {
		return ourInstance;
	}

	private ModelController() {
	}
}