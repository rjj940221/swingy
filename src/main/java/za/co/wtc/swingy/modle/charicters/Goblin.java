package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.artifact.Helm;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Random;

public class Goblin extends Monster {
	Goblin(@Min(0) int level,
	       @NotNull Coordinate coordinate) {
		super(CharacterType.GOBLIN, level, 0, 0, 0, 0, coordinate);
		experience = 0;
		attack = level * 10 + 5;
		defense = level * 10 + 5;
		hitPoints = 54 * level + 45;
	}

	@Override
	public Artifact dropArtifact() {
		Random rand = new Random();
		if (rand.nextInt(3) == 1) {

			return new Helm((rand.nextInt(level + 2) + 1) * 2);
		} else
			return null;
	}
}
