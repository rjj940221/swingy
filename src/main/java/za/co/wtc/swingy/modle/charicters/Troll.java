package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Troll extends Monster {
	public Troll(@Min(0) int level,
	             @NotNull Coordinate coordinate) {
		super(CharacterType.TROLL, level, 0, 0, 0, 0, coordinate);
		experience = 0;
		attack = level * 10 + 5;
		defense = level * 10 + 5;
		hitPoints = 60 * level + 60;
	}
}
