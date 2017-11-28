package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Random;

public class Monster extends Charicter {
	private static final String[] names = {"Borge", "Zignith", "Herrid"};

	public Monster(@NotNull String type,
	               @Min(0) int level,
	               @Min(0) long experience,
	               @Min(0) int attack,
	               @Min(0) int defense,
	               @Min(0) int hitPoints) {
		super(names[(int) (Math.random() * names.length)], type, level, experience, attack, defense, hitPoints, new Coordinate(0, 0));
	}

	public Monster(@NotNull String type,
	               @Min(0) int level,
	               @Min(0) long experience,
	               @Min(0) int attack,
	               @Min(0) int defense,
	               @Min(0) int hitPoints,
	               @NotNull Coordinate coordinate) {
		super(names[(int) (Math.random() * names.length)], type, level, experience, attack, defense, hitPoints, coordinate);
	}
}
