package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.GameState;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.view.GameCLI;

public class GameControllerCLI {
	private GameCLI gameView;
	private GameModel gameModel;

	public GameControllerCLI(GameCLI gameView, GameModel gameModel) {
		this.gameView = gameView;
		this.gameModel = gameModel;
	}

	public GameState runGame(){
		while (gameModel.getGameState() == GameState.InProgress){
			if (gameModel.canMove()){
				gameModel.moveHero(gameView.move());
			}else {
				if(gameView.fight(gameModel.getHero(), gameModel.getOponent())) {
					gameModel.fight();
					gameView.fightResult(gameModel.getHero(), gameModel.getOponent());
				}else {
					if (!gameModel.flee()){
						gameModel.fight();
						gameView.fightResult(gameModel.getHero(), gameModel.getOponent());
					}
				}
			}
		}
		if (gameModel.getGameState() == GameState.Victory){
			gameView.victory();
			gameModel.gameCompletionBonus();
			gameView.displayHero(gameModel.getHero());
			if (gameView.nextMap()) {
				gameModel.setLevel();
				return  runGame();
			}
			return GameState.Victory;
		}
		else{
			gameView.defeat();
			if (gameView.nextMap()) {
				gameModel.setLevel();
				return  runGame();
			}
			return GameState.Defeat;
		}
	}

	public Hero getHero(){
		return gameModel.getHero();
	}
}
