package za.co.wtc.swingy.modle;

import za.co.wtc.swingy.modle.artifact.Artifact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Hero extends Charicter {
    private Artifact weapon;
    private Artifact armor;
    protected Artifact helmet;

    public Hero(@NotNull String name, @NotNull String type, @Min(0) int level, @Min(0) long experience, @Min(0) int attack, @Min(0) int defense, @Min(0) int hitPoints) {
        super(name, type, level, experience, attack, defense, hitPoints);
    }

    public void increaceEXP(int exp) {
        experience += exp;
    }

    @Override
    public boolean takeDamage(int damage) {

        if (armor != null)
            damage = armor.takeDamage(damage);
        if (damage > defense) {
            int deduct = damage - defense;
            if (helmet != null) {
                deduct = helmet.takeDamage(deduct);
            }
            hitPoints = (hitPoints - deduct < 0) ? 0 : hitPoints - deduct;
            defense = 0;
        } else
            defense -= damage;
        return hitPoints != 0;
    }

    @Override
    public int getAttack() {
        if (weapon != null)
            return weapon.getValue() + attack;
        else
            return super.getAttack();
    }
}
