import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Павел on 12.05.2017.
 */
public class Game {
    public Map map;

    public Game() {
        System.out.println("Привет!");

        map = new Map(10, 20);
        map.render();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите команду:");
        String key = in.nextLine();

        while (!key.equals("q")) {
            clear();
            map.render();
            System.out.println("Введите команду:");
            key = in.nextLine();
        }

    }

    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

}
