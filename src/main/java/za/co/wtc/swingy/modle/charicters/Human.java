package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Human extends Hero{
	public Human(@NotNull String name,
	             @Min(0) int level,
	             @Min(0) long experience,
	             @Min(0) int attack,
	             @Min(0) int defense,
	             @Min(0) int hitPoints) {
		super(name, CharacterType.HUMAN, level, experience, attack, defense, hitPoints);
	}

	public Human(@NotNull String name,
	             @Min(0) int level,
	             @Min(0) long experience,
	             @Min(0) int attack,
	             @Min(0) int defense,
	             @Min(0) int hitPoints,
	             Artifact weapon,
	             Artifact armor,
	             Artifact helmet,
	             @Min(0) long id) {
		super(name, CharacterType.HUMAN, level, experience, attack, defense, hitPoints, weapon, armor, helmet, id);
	}

	public Human(@NotNull String name) {
		super(name, CharacterType.HUMAN);
		experience = 0;
		attack = level * 10 + 5;
		defense = level * 10 + 5;
		hitPoints = 50 * level + 50;
	}

	@Override
	public void fullHealth() {
		defense = level * 10 + 5;
		hitPoints = 50 * level + 50;
	}

	@Override
	protected void increaseStats() {
		attack = level * 10 + 5;
		defense = level * 10 + 5;
		hitPoints = 50 * level + 50;
	}
}
