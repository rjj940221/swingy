package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.view.gui.LoadCreateGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadCreateControllerGUI {
	private boolean trigered = false;
	private boolean create = false;
	private LoadCreateGUI view;

	public LoadCreateControllerGUI(LoadCreateGUI view) {
		this.view = view;
		view.addCreateListner(new CreateEvent());
		view.addLoadListner(new LoadEvent());
	}


	public void displayWindow(){
		view.setVisible(true);
	}

	class CreateEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			view.setVisible(false);
			WindowController.getIncetance().getCreateController().displayWindow();
		}
	}

	class LoadEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			WindowController.getIncetance().getSelectController().display();
			view.setVisible(false);
		}
	}
}
