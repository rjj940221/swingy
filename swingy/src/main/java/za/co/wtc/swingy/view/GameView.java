package za.co.wtc.swingy.view;

import za.co.wtc.swingy.modle.Direction;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.modle.charicters.Monster;

public interface GameView {

	boolean fight(Hero hero, Monster monster);

	Direction move();

	void victory();

	void defeat();

	void fightResult(Hero hero, Monster monster);
}
