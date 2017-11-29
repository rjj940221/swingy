package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.modle.charicters.Charicter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Hero extends Charicter {
	private Artifact weapon;
	private Artifact armor;
	protected Artifact helmet;
	@Min(0)
	protected long id;

	public Hero(@NotNull String name, @NotNull String type, @Min(0) int level, @Min(0) long experience, @Min(0) int attack, @Min(0) int defense, @Min(0) int hitPoints) {
		super(name, type, level, experience, attack, defense, hitPoints, new Coordinate(0, 0));
	}

	public Hero(@NotNull String name, @NotNull String type, @Min(0) int level, @Min(0) long experience, @Min(0) int attack, @Min(0) int defense, @Min(0) int hitPoints, @NotNull Coordinate coordinate, @Min(0) long id) {
		super(name, type, level, experience, attack, defense, hitPoints, coordinate);
		this.id = id;
	}

	public Hero(@NotNull String name, @NotNull String type, @Min(0) int level, @Min(0) long experience, @Min(0) int attack, @Min(0) int defense, @Min(0) int hitPoints, @NotNull Coordinate coordinate, Artifact weapon, Artifact armor, Artifact helmet, @Min(0) long id) {
		super(name, type, level, experience, attack, defense, hitPoints, coordinate);
		this.weapon = weapon;
		this.armor = armor;
		this.helmet = helmet;
		this.id = id;
	}

	public void increaseEXP(long exp) {
		experience += exp;
		int testLevel = level + 1;
		double testEx = ((testLevel * 1000) + Math.pow(level, 2)) * 450;
		if (experience >= testEx) {
			level += 1;
		}
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


	@Override
	public String toString() {
		return "Hero{" +
				       "weapon=" + weapon +
				       ", armor=" + armor +
				       ", helmet=" + helmet +
				       ", name='" + name + '\'' +
				       ", type='" + type + '\'' +
				       ", level=" + level +
				       ", experience=" + experience +
				       ", attack=" + attack +
				       ", defense=" + defense +
				       ", hitPoints=" + hitPoints +
				       ", coordinate=" + coordinate +
				       ", direction=" + direction +
				       '}';
	}
}
