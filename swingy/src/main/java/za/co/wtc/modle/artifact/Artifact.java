package za.co.wtc.modle.artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Artifact {
    @NotNull
    private ArtifactType type;
    @Min(0)
    private int value;
    @Min(0)
    private int maxValue;

    Artifact(ArtifactType type, int value) {
        this.type = type;
        this.value = value;
        maxValue = value;
    }

    public ArtifactType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int takeDamage(int damage){
        if (value - damage < 0 ) {
            damage -= value;
            value = 0;
            return damage;
        }
        else{
            value -= damage;
            return 0;
        }
    }
}
