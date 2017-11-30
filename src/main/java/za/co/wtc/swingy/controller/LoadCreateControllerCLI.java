package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.view.LoadCreateCLI;

public class LoadCreateControllerCLI {
	private LoadCreateCLI view;

	public LoadCreateControllerCLI(LoadCreateCLI view) {
		this.view = view;
	}

	public boolean create(){
			return view.loadOrCreate();
	}

}
