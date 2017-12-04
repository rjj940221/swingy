package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.FightState;
import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.GameState;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.gui.GameGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

class GameControllerGUI {
	private GameModel game;
	private GameGUI view;

	GameControllerGUI(GameModel game, GameGUI view) {
		this.game = game;
		this.view = view;
		this.view.setFightListner(new FightAction());
		this.view.setFleeListner(new FleeAction());
		this.view.setMoveListner(new MoveAction());
		this.view.setNextListner(new NextMap());
		this.view.setCLIListner(new CLI());
		this.view.setChangeHeroListner(new ChangHero());
		this.view.setQuitListner(new Quit());
		this.view.displayHeroStats(game.getHero());
		if (game.canMove()) {
			this.view.setMoveInteract(true);
			this.view.setFightInteracta(false);
		} else {
			this.view.setMoveInteract(false);
			this.view.setFightInteracta(true);
		}
	}

	void displayMenu(){
		view.displayHeroStats(null);
		view.displayEnemyStats(null);
		view.setVisible(true);
		view.displayMenu(true);
		System.out.println("display menu done");
	}

	private void setBtn() {
		if (game.canMove()) {
			this.view.setMoveInteract(true);
			this.view.setFightInteracta(false);
		} else {
			this.view.setMoveInteract(false);
			this.view.setFightInteracta(true);
			view.displayEnemyStats(game.getOponent());
		}
	}

	Boolean startMap(Hero hero) {
		game.setHero(hero);
		game.setLevel();
		view.setGameLog("Map started\n");
		setBtn();
		this.view.displayHeroStats(game.getHero());
		this.view.setVisible(true);
		return true;
	}

	Boolean startMap() {
		if (game.getHero() != null) {
			game.setLevel();
			view.setGameLog("Map started\n");
			setBtn();
			this.view.displayHeroStats(game.getHero());
			this.view.displayEnemyStats(game.getOponent());
			this.view.setVisible(true);
			return true;
		}
		return false;
	}

	private void fightConclusion(FightState state) {
		switch (state) {
			case DEFEAT:
				try {
					view.setFightInteracta(false);
					view.setMoveInteract(false);
					view.appendGameLog("YOU ARE DEFEATED");
					view.displayMenu(true);
					Connection con = SqlStore.getConnection();
					game.setHero(SqlStore.getHero(con, game.getHero().getID()));
					if (con != null) {
						con.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case VICTORY:
				view.appendGameLog("You are victories\n");
				if (game.canPickUp()) {
					if (JOptionPane.showConfirmDialog(view, "Opponent dropped an item\n\tType: " + game.getDropped().getType() + "\n\tValue: " + game.getDropped().getValue()) == 0) {
						game.pickUpArtifact();
					}
				}
				break;
			case INCOMBAT:
				view.appendGameLog("You are still fighting\n");
				break;
		}
		view.displayHeroStats(game.getHero());
		view.displayEnemyStats(game.getOponent());
		setBtn();
	}

	class FightAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fightConclusion(game.fight());
		}
	}

	class MoveAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			game.moveHero(Direction.valueOf(view.getMoveDirection()));
			if (game.getGameState() == GameState.Victory) {
				game.gameCompletionBonus();
				try {
					Connection con = SqlStore.getConnection();
					SqlStore.updateHero(con, game.getHero());
					if (con != null) {
						con.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				view.displayHeroStats(game.getHero());
				view.setFightInteracta(false);
				view.setMoveInteract(false);
				view.displayMenu(true);
			} else if (game.canMove()) {
				view.setFightInteracta(false);
				view.appendGameLog("Moved to empty coordinate\n");
			} else {
				view.appendGameLog("Found Enemy\n");
				view.displayEnemyStats(game.getOponent());
				view.setMoveInteract(false);
				view.setFightInteracta(true);
			}
		}
	}

	class FleeAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (game.flee()) {
				view.appendGameLog("You escaped conflict\n");
				setBtn();
				if (!game.canMove()) {
					view.appendGameLog("Unfortunately you ran into another enemy\n");
				}
				view.displayEnemyStats(game.getOponent());
			} else {
				view.appendGameLog("You could not evade your enemy and are forced to fight\n");
				fightConclusion(game.fight());
			}
		}
	}

	class NextMap implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			System.out.println("Got next map event");
			startMap();
			view.displayMenu(false);
		}
	}

	class CLI implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			view.displayMenu(false);
			view.setVisible(false);
			WindowController.getIncetance().getGameControllerCLI().displayMenu();
		}
	}

	class ChangHero implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			view.displayMenu(false);
			view.setVisible(false);
			view.setFocusable(true);
			WindowController.getIncetance().getLoadCreateController().displayWindow();

		}
	}

	class Quit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				Connection con = SqlStore.getConnection();
				SqlStore.updateHero(con, game.getHero());
				con.close();
				System.exit(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
