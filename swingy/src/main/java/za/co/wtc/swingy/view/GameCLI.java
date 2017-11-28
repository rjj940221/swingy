package za.co.wtc.swingy.view;

import java.io.Console;

public class GameCLI {
    public GameCLI() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }else{
            c.printf("Game launched");
            c.flush();
            System.err.println("Yes console.");
            /*try {
                byte [] rbuf = new  byte[100];
                System.in.read(rbuf);
                System.out.println(new String(rbuf, StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

}
