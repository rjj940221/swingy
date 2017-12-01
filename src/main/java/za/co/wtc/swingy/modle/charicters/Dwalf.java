package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.artifact.Artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Dwalf extends  Hero{

	public Dwalf(@NotNull String name,
	             @Min(0) int level,
	             @Min(0) long experience,
	             @Min(0) int attack,
	             @Min(0) int defense,
	             @Min(0) int hitPoints) {
		super(name, CharacterType.DWARF, level, experience, attack, defense, hitPoints);
	}

	public Dwalf(@NotNull String name,
	             @Min(0) int level,
	             @Min(0) long experience,
	             @Min(0) int attack,
	             @Min(0) int defense,
	             @Min(0) int hitPoints,
	             @Min(0) long id) {
		super(name, CharacterType.DWARF, level, experience, attack, defense, hitPoints, id);
	}

	public Dwalf(@NotNull String name,

	             @Min(0) int level,
	             @Min(0) long experience,
	             @Min(0) int attack,
	             @Min(0) int defense,
	             @Min(0) int hitPoints,
	             Artifact weapon,
	             Artifact armor,
	             Artifact helmet,
	             @Min(0) long id) {
		super(name, CharacterType.DWARF, level, experience, attack, defense, hitPoints, weapon, armor, helmet, id);
	}

	public Dwalf(@NotNull String name) {
		super(name, CharacterType.DWARF);
		experience = 0;
		attack = level * 10 + 5;
		defense = level * 10 + 5;
		hitPoints = 60 * level + 60;
	}
}
