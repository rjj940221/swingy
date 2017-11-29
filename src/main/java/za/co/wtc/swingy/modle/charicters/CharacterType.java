package za.co.wtc.swingy.modle.charicters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CharacterType {
		HUMAN,
		ELF,
		DWARF,
		ORC,
		GOBLIN,
		TROLL;

	public List<CharacterType> getHero(){
			return new ArrayList<CharacterType>(Arrays.asList(HUMAN, ELF, DWARF));
	}

	public  List<CharacterType> getEnemy(){
		return new ArrayList<CharacterType>(Arrays.asList(ORC, GOBLIN, TROLL));
	}
}
