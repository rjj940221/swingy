package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.HeroSelectGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class HeroSelectControllerGUI {
	private HeroSelectGUI view;
	private Hero hero;
	private Connection con;

	public HeroSelectControllerGUI(HeroSelectGUI view) {
		this.view = view;
		try {
			con = SqlStore.getConnection();
			this.view.setModel(SqlStore.listHerose(con));
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
		}
	}
}
