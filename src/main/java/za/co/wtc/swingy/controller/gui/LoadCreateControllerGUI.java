package za.co.wtc.swingy.controller.gui;

import za.co.wtc.swingy.view.gui.HeroCreateGUI;
import za.co.wtc.swingy.view.gui.HeroSelectGUI;
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
			WindowController.getIncetance().getHeroCreate().setVisible(true);
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
