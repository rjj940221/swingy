package za.co.wtc.swingy.controller.gui;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.charicters.CharacterType;
import za.co.wtc.swingy.modle.charicters.CharicterFactory;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.gui.GameGUI;
import za.co.wtc.swingy.view.gui.HeroCreateGUI;
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
					hero = CharicterFactory.creatHero(CharacterType.valueOf(type),name);
					Connection con = SqlStore.getConnection();
					int id = SqlStore.addHero(con, hero);
					hero.setId(id);
					con.close();
					view.setVisible(false);
					WindowController.getIncetance().getGameController().startMap(hero);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}else{
				JOptionPane.showMessageDialog(view,"Please enter a Hero name");
			}
		}
	}
	
}
