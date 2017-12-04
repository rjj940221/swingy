package za.co.wtc.swingy.modle.charicters;

import za.co.wtc.swingy.modle.Coordinate;
import za.co.wtc.swingy.modle.artifact.Artifact;
import za.co.wtc.swingy.store.SqlStore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Hero extends Charicter {
	private Artifact weapon;
	private Artifact armor;
	private Artifact helmet;
	protected long id;

	public Hero(@NotNull String name,
	            @NotNull CharacterType type,
	            @Min(0) int level,
	            @Min(0) long experience,
	            @Min(0) int attack,
	            @Min(0) int defense,
	            @Min(0) int hitPoints) {
		super(name, type, level, experience, attack, defense, hitPoints, new Coordinate(0, 0));
		armor = null;
		weapon = null;
		helmet = null;
		id = -1;
	}

	public Hero(@NotNull String name,
	            @NotNull CharacterType type,
	            @Min(0) int level,
	            @Min(0) long experience,
	            @Min(0) int attack,
	            @Min(0) int defense,
	            @Min(0) int hitPoints,
	            @Min(0) long id) {
		super(name, type, level, experience, attack, defense, hitPoints, new Coordinate(0,0));
		this.id = id;
		armor = null;
		weapon = null;
		helmet = null;
	}

	public Hero(@NotNull String name,
	            @NotNull CharacterType type,
	            @Min(0) int level,
	            @Min(0) long experience,
	            @Min(0) int attack,
	            @Min(0) int defense,
	            @Min(0) int hitPoints,
	            Artifact weapon,
	            Artifact armor,
	            Artifact helmet,
	            @Min(0) long id) {
		super(name, type, level, experience, attack, defense, hitPoints, new Coordinate(0,0));
		this.weapon = weapon;
		this.armor = armor;
		this.helmet = helmet;
		this.id = id;
	}


	public Hero(@NotNull String name, @NotNull CharacterType type) {
		super(name, type);
		armor = null;
		weapon = null;
		helmet = null;
		id = -1;
	}

	public void increaseEXP(long exp) {
		experience += exp;
		int testLevel = level + 1;
		double testEx = (testLevel * 1000) + Math.pow(level, 2) * 450;
		System.out.println("Increased ex testing next level: " + testEx);
		if (experience >= testEx) {
			level += 1;
			increaseStats();
		}
	}

	public abstract void fullHealth();

	protected abstract void increaseStats();

	public void setId(long id) {
		this.id = id;
	}

	public long getID() {
		return id;
	}

	public Artifact getWeapon() {
		return weapon;
	}

	public Artifact getArmor() {
		return armor;
	}

	public Artifact getHelmet() {
		return helmet;
	}

	public void pickUpArtifact(Artifact artifact){
		switch (artifact.getType()) {
			case Helm:
				if (helmet == null){
					try {
						Connection con = SqlStore.getConnection();
						artifact.setId(SqlStore.addArtifact(con, artifact));
						if(con != null)
							con.close();
						helmet = artifact;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					artifact.setId(helmet.getId());
					helmet = artifact;
				}
				break;
			case Armor:
				if (armor == null){
					try {
						Connection con = SqlStore.getConnection();
						artifact.setId(SqlStore.addArtifact(con, artifact));
						if(con != null)
							con.close();
						armor = artifact;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					artifact.setId(armor.getId());
					armor = artifact;
				}
				break;
			case Weapon:
				if (weapon == null){
					try {
						Connection con = SqlStore.getConnection();
						artifact.setId(SqlStore.addArtifact(con, artifact));
						if(con != null)
							con.close();
						weapon = artifact;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					artifact.setId(weapon.getId());
					weapon = artifact;
				}
				break;
		}
	}

	@Override
	public boolean takeDamage(int damage) {

		if (armor != null) {
			damage = damage - armor.getValue();
			if(damage < 0)
				damage = 0;
		}
		if (damage > defense) {
			int deduct = damage - defense;
			/*if (helmet != null) {
				deduct = helmet.takeDamage(deduct);
			}*/
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
				", id=" + id +
				", name='" + name + '\'' +
				", type=" + type +
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
