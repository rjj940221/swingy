package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;

import java.util.Random;

public abstract class CharicterFactory {
	public static Hero creatHero(CharacterType type, String name) {
		switch (type) {
			case DWARF:
				return new Dwalf(name);
			case ELF:
				return new Elf(name);
			case HUMAN:
				return new Human(name);
			default:
				return null;
		}
	}

	public static Hero creatHero(CharacterType type,
	                             String name,
	                             int level,
	                             long experience,
	                             int attack,
	                             int defence,
	                             int hitPoint,
	                             Artifact weapon,
	                             Artifact armor,
	                             Artifact helmet,
	                             long id) {
		switch (type) {
			case DWARF:
				return new Dwalf(name, level, experience, attack, defence, hitPoint, weapon, armor, helmet, id);
			case ELF:
				return new Elf(name, level, experience, attack, defence, hitPoint, weapon, armor, helmet, id);
			case HUMAN:
				return new Human(name, level, experience, attack, defence, hitPoint, weapon, armor, helmet, id);
			default:
				return null;
		}
	}

	public static Monster randomMonster(int levelLimit, Coordinate coordinate) {
		Random rand = new Random();
		int level = rand.nextInt(levelLimit);
		switch (rand.nextInt(3)) {
			case 0:
				return new Orc(level, coordinate);
			case 1:
				return new Troll(level, coordinate);
			case 2:
				return new Goblin(level, coordinate);
			default:
				return null;
		}
	}
}
