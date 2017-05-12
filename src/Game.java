import com.sun.javafx.geom.Vec2d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Павел on 12.05.2017.
 */
public class Game {
    public Map map;
    public Player player;
    public ArrayList<Rat> enemies;

    public Game() {
        clear();
        System.out.print("Добро пожаловать! Введите свое имя: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        map = new Map(20, 40);

        player = new Player(name, 10, map.genRndPos(), "Player", "@" );

        enemies = new ArrayList<Rat>();
        enemies.add(Rat.spawn(map, enemies.size()));
        //enemies.add(new Rat("Rat01", 100, new Vec2d(10, 10), "Enemy", "r"));

        clear();
        map.render(player, enemies);
        player.print();

        System.out.println("Введите команду: ");
        String key = in.nextLine();

        while (!key.equals("q")) {
            clear();

            switch (key){
                case "w":
                    player.move(new Vec2d(-1, 0), map);
                break;
                case "s":
                    player.move(new Vec2d(1, 0), map);
                break;
                case "a":
                    player.move(new Vec2d(0, -1), map);
                break;
                case "d":
                    player.move(new Vec2d(0, 1), map);
                break;
            }

            map.render(player, enemies);
            player.print();
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
