import com.sun.javafx.geom.Vec2d;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Павел on 12.05.2017.
 */
public class Game {
    public Map map;
    public Player player;

    public Game() {
        clear();
        System.out.print("Добро пожаловать! Введите свое имя: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        player = new Player(name, 10, new Vec2d(10, 20), "Player" );
        clear();

        System.out.println("Привет! " + player.name);

        map = new Map(10, 20);
        map.render();

        System.out.println("Введите команду: ");
        String key = in.nextLine();

        while (!key.equals("q")) {
            clear();
            map.render();
            System.out.println("Введите команду: ");
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
