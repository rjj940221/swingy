package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.view.HeroCreateGUI;
import za.co.wtc.swingy.view.HeroSelectGUI;
import za.co.wtc.swingy.view.LoadCreateGUI;

import javax.swing.*;
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

	/*public boolean create(){
		while (!trigered){

		}
		view.close();
		return create;
	}*/

	class CreateEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			view.setVisible(false);
			new HeroCreateControllerGUI(new HeroCreateGUI());
		}
	}

	class LoadEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			trigered = true;
			create = false;
			System.out.println("Load :" + trigered);
			new HeroSelectControllerGUI(new HeroSelectGUI());
			view.setVisible(false);
		}
	}
}
