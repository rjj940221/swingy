package za.co.wtc.swingy.view;

import java.io.Console;

public class LoadCreatCLI implements LoadCreatView {
	private Console console;

	public LoadCreatCLI() {
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		} else {
			console.printf("Yes console.\n");
		}
	}

	@Override
	public boolean loadOrCreate() {
		String responce;
		do {
			responce = console.readLine("Do you want to load an existing hero?[y/n]: ");
		} while (!responce.equalsIgnoreCase("y") && !responce.equalsIgnoreCase("n"));
		return (responce.equalsIgnoreCase("y"));
	}
}
