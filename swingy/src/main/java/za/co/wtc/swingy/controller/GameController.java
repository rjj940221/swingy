package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.GameModel;
import za.co.wtc.swingy.modle.GameState;
import za.co.wtc.swingy.view.GameView;

public class GameController {
	private GameView gameView;
	private GameModel gameModel;

	public GameController(GameView gameView, GameModel gameModel) {
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
				}else {
					if (!gameModel.flee()){
						gameModel.fight();
					}
				}
			}
		}
		if (gameModel.getGameState() == GameState.Victory){
			gameView.victory();
			return GameState.Victory;
		}
		else{
			gameView.defeat();
			return GameState.Defeat;
		}
	}
}
