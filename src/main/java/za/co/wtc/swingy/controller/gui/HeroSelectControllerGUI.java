package za.co.wtc.swingy.controller.gui;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.gui.GameGUI;
import za.co.wtc.swingy.view.gui.HeroSelectGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HeroSelectControllerGUI {
	private HeroSelectGUI view;
	private Hero hero;
	private List<Hero> heros;
	private Connection con;

	public HeroSelectControllerGUI(HeroSelectGUI view) {
		this.view = view;

	}

	public void display(){
		view.setVisible(true);
		try {
			con = SqlStore.getConnection();
			heros = SqlStore.listHerose(con);
			this.view.setModel(heros);
			this.view.addButtonListner(new btnSelect());
			this.view.addListListner(new lstSelect());
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.close();
		}
	}

	class lstSelect implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent listSelectionEvent) {
			view.enableSelect();
		}
	}

	class btnSelect implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			hero = view.getSelected();
			view.setVisible(false);
			WindowController.getIncetance().getGameController().startMap(hero);
		}
	}
}
