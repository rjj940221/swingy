package za.co.wtc.swingy.view;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.modle.charicters.Monster;

import java.io.Console;

public class GameCLI implements GameView {
	private Console console;

	public GameCLI() {
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		} else {
			console.printf("Yes console.\n");
		}
	}

	public boolean fight(Hero hero, Monster monster) {
		String responce;
		console.printf("Hero {Name: %s, Class: %s, Level: %d, Attack: %d, Defence: %d, Hit Points: %d}\n",
				hero.getName(), hero.getType(), hero.getLevel(), hero.getAttack(), hero.getDefense(),
				hero.getHitPoints());
		console.printf("Opponent {Name: %s, Class: %s, Level: %d, Attack: %d, Defence: %d, Hit Points: %d}\n",
				monster.getName(), monster.getType(), monster.getLevel(), monster.getAttack(), monster.getDefense(),
				monster.getHitPoints());
		do {
			responce = console.readLine("Do you want to fight?[y/n]: ");
		} while (!responce.equalsIgnoreCase("y") && !responce.equalsIgnoreCase("n"));
		return (responce.equalsIgnoreCase("y"));
	}

	public Direction move() {
		String responce;
		String answers = "nsew";
		do {
			responce = console.readLine("Which direction do you want to move?[n/e/s/w]: ");
		} while (responce.length() > 1 && !answers.contains(responce));
		switch (responce) {
			case "n":
				return Direction.North;
			case "s":
				return Direction.South;
			case "e":
				return Direction.East;
			case "w":
				return Direction.West;
			default:
				return Direction.None;
		}
	}

	@Override
	public void victory() {
		console.readLine("VICTORY: ");
	}

	@Override
	public void defeat() {
		console.readLine("DEFEAT: ");
	}

	@Override
	public void fightResult(Hero hero, Monster monster) {
		console.printf("Hero {Name: %s, Defence: %d, Hit Points: %d}\n",
				hero.getName(), hero.getDefense(), hero.getHitPoints());
		console.printf("Opponent {Name: %s, Defence: %d, Hit Points: %d}\n",
				monster.getName(), monster.getDefense(), monster.getHitPoints());
	}
}