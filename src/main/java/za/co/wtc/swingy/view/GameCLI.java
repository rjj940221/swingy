package za.co.wtc.swingy.view;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.modle.charicters.Monster;

import java.io.Console;

public class GameCLI {
	private Console console;

	public GameCLI() {
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		} /*else {
			console.printf("Yes console.\n");
		}*/
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

	public void victory() {
		console.readLine("VICTORY: ");
	}

	public void defeat() {
		console.readLine("DEFEAT: ");
	}

	public void fightResult(Hero hero, Monster monster) {
		console.printf("FIGHT RESULT:\n");
		if (monster != null) {
			console.printf("\033[33m\tHero {Name: %s, Defence: %d, Hit Points: %d} dealt %d damage \n",
					hero.getName(), hero.getDefense(), hero.getHitPoints(), monster.getLastDamage());
			console.printf("\033[31m\tOpponent {Name: %s, Defence: %d, Hit Points: %d} dealt %d damage \n\033[0m",
					monster.getName(), monster.getDefense(), monster.getHitPoints(), hero.getLastDamage());
		}else
		{
			console.printf("\t %s is victorious\n", hero.getName());
		}
	}

	public int displayMenu() {
		String res;
		int resIdx;

		do{
			res = console.readLine("Menu: \n"+
					"\t1: Next Map\n\t2: GUI\n\t3: Change Hero\n\t4: Quit\n: ");
			try {
				resIdx = Integer.parseInt(res);

			}catch(Exception e){
				resIdx = -1;
			}
		}while(resIdx < 0 || resIdx > 4);
		return (resIdx - 1);
	}

	public void displayHero(Hero hero) {
		console.printf("Hero {Name: %s, Class: %s, Level: %d, Experience: %d Attack: %d, Defence: %d, Hit Points: %d}\n",
				hero.getName(), hero.getType(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefense(),
				hero.getHitPoints());
	}

	public boolean pickupArtifact(Artifact artifact){
		String responce;
		do {
			responce = console.readLine("found %s of value %d do you want to take it [y/n]: ", artifact.getType(), artifact.getValue());
		} while (!responce.equalsIgnoreCase("y") && !responce.equalsIgnoreCase("n"));
		return (responce.equalsIgnoreCase("y"));
	}
}
