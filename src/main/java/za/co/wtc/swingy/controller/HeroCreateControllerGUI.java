package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.charicters.CharacterType;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.GameGUI;
import za.co.wtc.swingy.view.HeroCreateGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class HeroCreateControllerGUI {
	HeroCreateGUI view;
	Hero hero;

	public HeroCreateControllerGUI(HeroCreateGUI view) {
		this.view = view;
		this.view.addCreateListner(new Create());
	}

	class Create implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = view.getHeroName();
			String type = view.getHeroClass();

			if (!name.trim().isEmpty()){

				try {
					hero = new Hero(name, CharacterType.valueOf(type),0,0,10,5,40);
					Connection con = SqlStore.getConnection();
					int id = SqlStore.addHero(con, hero);
					hero.setId(id);
					con.close();
					new GameControllerGUI(new GameModel(hero), new GameGUI());
					view.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}else{
				JOptionPane.showMessageDialog(view,"Please enter a Hero name");
			}
		}
	}
	
}
