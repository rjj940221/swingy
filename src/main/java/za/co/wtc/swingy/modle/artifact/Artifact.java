package za.co.wtc.swingy.modle.artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Artifact {
    @NotNull
    private ArtifactType type;
    @Min(0)
    private int value;
    @Min(0)
    private int maxValue;
    private int id;

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

    public Artifact(@NotNull ArtifactType type, @Min(0) int value, @Min(0) int maxValue, int id) {
        this.type = type;
        this.value = value;
        this.maxValue = maxValue;
        this.id = id;
    }

    public ArtifactType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
