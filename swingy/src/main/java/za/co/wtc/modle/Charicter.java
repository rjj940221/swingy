package za.co.wtc.modle;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Charicter {
    @NotNull
    protected String name;
    @NotNull
    protected String type;
    @Min(0)
    protected int level;
    @Min(0)
    protected long experience;
    @Min(0)
    protected int attack;
    @Min(0)
    protected int defense;
    @Min(0)
    protected int  hitPoints;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public long getExperience() {
        return experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean takeDamage(int damage){
        if (damage > defense) {
            int deduct = damage - defense;
            hitPoints = (hitPoints - deduct < 0)? 0 : hitPoints - deduct;
            defense = 0;
        }
        else
            defense -= damage;
        return hitPoints != 0;
    }

    public Charicter(@NotNull String name, @NotNull String type, @Min(0) int level, @Min(0) long experience, @Min(0) int attack, @Min(0) int defense, @Min(0) int hitPoints) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }
}
