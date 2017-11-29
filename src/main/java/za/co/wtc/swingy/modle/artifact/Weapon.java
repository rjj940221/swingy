package za.co.wtc.swingy.modle.artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Weapon extends Artifact {
    public Weapon(@Min(0) int value) {
        super(ArtifactType.Weapon, value);
    }

    public Weapon(@Min(0) int value, @Min(0) int maxValue) {
        super(ArtifactType.Weapon, value, maxValue);
    }
}
