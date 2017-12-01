package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.FightState;
import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.GameState;
import za.co.wtc.swingy.view.GameGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControllerGUI {
	private GameModel game;
	private GameGUI view;

	public GameControllerGUI(GameModel game, GameGUI view) {
		this.game = game;
		this.view = view;
		this.view.setFightListner(new FightAction());
		this.view.setFleeListner(new FleeAction());
		this.view.setMoveListner(new MoveAction());
		this.view.displayHeroStats(game.getHero());
		if (game.canMove()) {
			this.view.setMoveInteract(true);
			this.view.setFightInteracta(false);
		}
	}

	private void fightConclusion(FightState state) {
		view.displayHeroStats(game.getHero());
		if (game.canMove()) {
			view.setFightInteracta(false);
			view.setMoveInteract(true);
		}
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
			System.out.println("Direction: " + view.getMoveDirection());
			game.moveHero(Direction.valueOf(view.getMoveDirection()));
			if (game.getGameState() == GameState.Victory) {
				game.gameCompletionBonus();
				view.displayHeroStats(game.getHero());
				view.setFightInteracta(false);
				view.setMoveInteract(false);
				JOptionPane.showMessageDialog(view, "Map Complected");
			} else if (game.canMove()) {
				view.setFightInteracta(false);
			} else {
				view.setMoveInteract(false);
				view.setFightInteracta(true);
			}
		}
	}

	class FleeAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (game.flee()) {
				if (game.canMove()) {
					view.setFightInteracta(false);
					view.setMoveInteract(true);
				}
			} else {
				fightConclusion(game.fight());
			}
		}
	}
}
