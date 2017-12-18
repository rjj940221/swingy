package za.co.wtc.swingy.view;

import za.co.wtc.swingy.modle.charicters.CharacterType;

import java.io.Console;
import java.util.List;

public class HeroCreateCLI{
	private Console console;

	public HeroCreateCLI() {
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}/* else {
			console.printf("Yes console.\n");
		}*/
	}

	public String getHeroName() {
		String responce;
		do {
			responce = console.readLine("Name your hero: ");
		} while (responce.trim().isEmpty());
		return (responce);
	}

	public String getHeroClass() {
		List<String> options = CharacterType.getHero();
		int idx = 1;
		String res;
		int resIdx;

		for (String opt : options) {
			console.printf("%d %s\n", idx++, opt);
		}
		do{
			res = console.readLine("Enter the index of the hero you want to use: ");
			try {
				resIdx = Integer.parseInt(res);
			}catch(Exception e){
				resIdx = -1;
			}
		}while(resIdx < 1 || resIdx > options.size());
		return options.get(resIdx - 1).toString();
	}
}
