package za.co.wtc.swingy.modle.charicters;


import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.artifact.Weapon;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Random;

public class Orc extends Monster {
	public Orc(@Min(0) int level,
	           @NotNull Coordinate coordinate) {
		super(CharacterType.ORC, level, 0, 0, 0, 0, coordinate);
		experience = 0;
		attack = level * 10 + 5;
		defense = level * 10 + 5;
		hitPoints = 50 * level + 50;
	}

	@Override
	public Artifact dropArtifact() {
		//if (new Random().nextInt(3) == 1) {
			return new Weapon((level + 1) * 2);
		//}else
		//	return null;
	}
}
