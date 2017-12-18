package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.Direction;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Charicter {
	@NotNull
	protected String name;
	@NotNull
	protected CharacterType type;
	@Min(0)
	protected int level;
	@Min(0)
	protected long experience;
	@Min(0)
	protected int attack;
	@Min(0)
	protected int defense;
	@Min(0)
	protected int hitPoints;
	@NotNull
	protected Coordinate coordinate;
	@NotNull
	protected Direction direction;
	protected int damageTaken;

	public String getName() {
		return name;
	}

	public CharacterType getType() {
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

	public Direction getDirection() {
		return direction;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void move(Direction direction) {
		this.direction = direction;
		coordinate.advance(direction);
	}

	public boolean takeDamage(int damage) {
		if (damage > defense) {
			int deduct = damage - defense;
			this.damageTaken = deduct;
			hitPoints = (hitPoints - deduct < 0) ? 0 : hitPoints - deduct;
			defense = 0;
		} else {
			this.damageTaken = 0;
			defense -= damage;
		}
		return hitPoints != 0;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	Charicter(@NotNull String name, @NotNull CharacterType type, @Min(0) int level, @Min(0) long experience, @Min(0) int attack, @Min(0) int defense, @Min(0) int hitPoints, @NotNull Coordinate coordinate) {
		this.name = name;
		this.type = type;
		this.level = level;
		this.experience = experience;
		this.attack = attack;
		this.defense = defense;
		this.hitPoints = hitPoints;
		this.coordinate = coordinate;
		this.direction = Direction.North;
		damageTaken = 0;
	}

	public Charicter(@NotNull String name, @NotNull CharacterType type) {
		this.name = name;
		this.type = type;
		this.level = 0;
		this.experience = 0;
		this.attack = 0;
		this.defense = 0;
		this.hitPoints = 0;
		this.coordinate = new Coordinate(0,0);
		this.direction = Direction.North;
		damageTaken = 0;
	}

	public int getLastDamage(){
		return damageTaken;
	}

	@Override
	public String toString() {
		return "{\n\tname: '" + name + '\'' +
				       "\n\ttype='" + type + '\'' +
				       "\n\tlevel=" + level +
				       "\n\texperience=" + experience +
				       "\n\tattack=" + attack +
				       "\n\tdefense=" + defense +
				       "\n\thitPoints=" + hitPoints +
				       "\n\tcoordinate=" + coordinate +
				       "\n\tdirection=" + direction +
				       "\n}";
	}
}
