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

	public static ArrayList<String> getHero(){
			return new ArrayList<String>(Arrays.asList("HUMAN", "ELF", "DWARF"));
	}

	public  static List<String> getEnemy(){
		return new ArrayList<String>(Arrays.asList("ORC", "GOBLIN", "TROLL"));
	}
}
