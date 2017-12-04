package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.gui.HeroSelectGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroSelectControllerGUI {
	private HeroSelectGUI view;
	private List<Hero> heros;
	private Connection con;

	public HeroSelectControllerGUI(HeroSelectGUI view) {
		this.view = view;
		this.view.addButtonListner(new btnSelect());
		this.view.addListListner(new lstSelect());
	}

	public void display() {
		System.out.println("Setting up load screen set vis and disable select");
		view.setVisible(true);
		view.enableSelect(false);
		try {
			con = SqlStore.getConnection();
			heros = SqlStore.listHerose(con);
			List<String> names = new ArrayList<>();
			for (Hero hero : heros) {
				names.add(hero.getName());
			}
			this.view.setModel(names);


		} catch (SQLException e) {
			e.printStackTrace();
			System.err.close();
		}
	}

	class lstSelect implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent listSelectionEvent) {
			if (view.getSelected() > -1) {
				view.enableSelect(true);
				view.displayHeroStats(heros.get(view.getSelected()));
			}
		}
	}

	class btnSelect implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Hero hero = heros.get(view.getSelected());
			view.setSelectNone();
			view.setVisible(false);
			WindowController.getIncetance().getGameControllerGUI().startMap(hero);
		}
	}
}
