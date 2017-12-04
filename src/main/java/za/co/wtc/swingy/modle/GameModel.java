package za.co.wtc.swingy.modle;

import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.charicters.CharacterType;
import za.co.wtc.swingy.modle.charicters.CharicterFactory;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.modle.charicters.Monster;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
	private Hero hero;
	private List<Monster> monsters = new ArrayList<>();
	private Monster oponent;
	private int size;
	private Artifact dropped = null;

	public GameModel(Hero hero) {
		this.hero = hero;
		setLevel();
	}

	public void setLevel(){
		if (hero != null) {
			hero.fullHealth();
			monsters.clear();
			size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
			System.out.println("size: " + size);
			this.hero.setCoordinate(new Coordinate(size / 2, size / 2));
			int numMonsters = ((size * size) / 4 - ((int) (Math.random() * 2)));
			int x, y;
			for (int i = 0; i <= numMonsters; i++) {
				x = (int) (Math.random() * (size + 1));
				y = (int) (Math.random() * (size + 1));
				//System.out.println("Placed monster at " + x + " " + y);
				monsters.add(CharicterFactory.randomMonster(hero.getLevel() + 1, new Coordinate(x, y)));
			}
			oponent = null;
		}
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Monster getOponent() {
		return oponent;
	}

	public boolean canPickUp()
	{
		return dropped != null;
	}

	public void pickUpArtifact() {
		if (dropped != null){
			hero.pickUpArtifact(dropped);
		}
	}

	public Artifact getDropped() {
		return dropped;
	}

	public boolean canMove() {
		for (Monster monster : monsters) {
			if (hero.getCoordinate().equals(monster.getCoordinate())) {
				oponent = monster;
				return false;
			}
		}
		if (hero == null || hero.getCoordinate().getX() < 0 ||
				hero.getCoordinate().getX() > size ||
				hero.getCoordinate().getY() < 0||
				hero.getCoordinate().getY() > size){
			return false;
		}
		return true;
	}

	public void moveHero(Direction direction) {
		hero.move(direction);
		dropped = null;
	}

	public Boolean flee() {
		if ((int) (Math.random() * 2) == 1) {
			hero.move(hero.getDirection().oposite());
			oponent = null;
			for (Monster monster : monsters) {
				if (hero.getCoordinate().equals(monster.getCoordinate())) {
					oponent = monster;
				}
			}
			return true;
		}
		return false;
	}

	public FightState fight() {
		if (oponent != null) {
			oponent.takeDamage(hero.getAttack());
			hero.takeDamage(oponent.getAttack());
			if(oponent.getHitPoints() == 0) {
				long exp = 20 * (oponent.getLevel() + 1);
				if (oponent.getLevel() > hero.getLevel())
					exp += (oponent.getLevel() - hero.getLevel()) * 80;
				if(oponent.getLevel() >= hero.getLevel())
				{
					dropped = oponent.dropArtifact();
				}
				//System.out.println("Fight exp: " + exp);
				hero.increaseEXP(exp);
				monsters.remove(oponent);
				oponent = null;
				return FightState.VICTORY;
			}
		}
		if(hero.getHitPoints() == 0){
			return FightState.DEFEAT;
		}
		return FightState.INCOMBAT;
	}

	public GameState getGameState() {
		if (hero.getHitPoints() == 0)
			return GameState.Defeat;
		if (hero.getCoordinate().getX() < 0 ||
				    hero.getCoordinate().getX() > size ||
				    hero.getCoordinate().getY() < 0||
					hero.getCoordinate().getY() > size){
			return GameState.Victory;
		}
		return GameState.InProgress;
	}

	public void gameCompletionBonus(){
		hero.increaseEXP(size * size);
	}
}
