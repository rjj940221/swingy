package za.co.wtc.swingy.modle.artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Artifact {
    @NotNull
    private ArtifactType type;
    @Min(0)
    private int value;
    @Min(0)
    private int maxValue;

    public Artifact(@NotNull ArtifactType type, @Min(0) int value) {
        this.type = type;
        this.value = value;
        maxValue = value;
    }

    public Artifact(@NotNull ArtifactType type, @Min(0) int value, @Min(0) int maxValue) {
        this.type = type;
        this.value = value;
        this.maxValue = maxValue;
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
