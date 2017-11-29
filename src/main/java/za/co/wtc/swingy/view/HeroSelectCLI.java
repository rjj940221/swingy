package za.co.wtc.swingy.view;

import za.co.wtc.swingy.modle.charicters.Hero;

import java.io.Console;
import java.util.List;

public class HeroSelectCLI implements HeroSelectView {
	private Console console;

	public HeroSelectCLI() {
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		} else {
			console.printf("Yes console.\n");
		}
	}

	@Override
	public Hero selectHero(List<Hero> heros) {
		int index = 1;
		String res;
		int resIdx;
		for (Hero hero :				heros) {
			console.printf("%d: %s\n",index++, hero.toString());
		}
		do{
			res = console.readLine("Enter the index of the hero you want to use: ");
			try {
				resIdx = Integer.parseInt(res);
			}catch(Exception e){
				resIdx = -1;
			}
		}while(resIdx < 0 || resIdx > heros.size());
		return null;
	}



}
