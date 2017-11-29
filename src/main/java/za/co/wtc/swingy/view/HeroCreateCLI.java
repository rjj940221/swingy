package za.co.wtc.swingy.view;

import java.io.Console;

public class HeroCreateCLI implements HeroCreateView{
	private Console console;

	public HeroCreateCLI() {
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		} else {
			console.printf("Yes console.\n");
		}
	}


	@Override
	public String getHeroName() {
		String responce;
		do {
			responce = console.readLine("Name your hero: ");
		} while (responce.trim().isEmpty());
		return (responce);
	}

	@Override
	public String GetHeroClass() {
		console.printf("Your hero is a heavy\n");
		return "Heavy";
	}
}
