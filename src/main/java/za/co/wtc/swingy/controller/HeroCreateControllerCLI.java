package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.charicters.CharacterType;
import za.co.wtc.swingy.modle.charicters.CharicterFactory;
import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.view.HeroCreateCLI;

public class HeroCreateControllerCLI {

	private HeroCreateCLI view;

	public HeroCreateControllerCLI(HeroCreateCLI view) {
		this.view = view;
	}

	public Hero getNewHero(){
		String name;
		String type;

		name = view.getHeroName();
		type = view.getHeroClass();
		return CharicterFactory.creatHero(CharacterType.valueOf(type),name);
	}
}
