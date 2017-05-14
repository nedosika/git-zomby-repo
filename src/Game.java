import com.sun.javafx.geom.Vec2d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Павел on 12.05.2017.
 */
public class Game {
    public Map map = new Map(20, 80);
    public Player player;
    static public ArrayList<String> log = new ArrayList<String>();


    public Game() throws IOException {
        clear();
        System.out.print("Добро пожаловать! Введите свое имя: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        player = new Player(name, 10, "Player", "@", 1, "Online" );
        map.addUnit(player);

        for (int i = 0; i < 10; i++) {
            map.addUnit(new Rat("Rat" + i, 2, "Enemy", "r", 1, "Online"));
        }

        clear();
        map.render();
        player.print();

        for (String log: log) {
            System.out.println(log);
        }
        log = new ArrayList<>();

        System.out.println("Введите команду: ");
        String key = in.nextLine();

        while (!key.equals("qq")) {
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
                case "q":
                    player.move(new Vec2d(-1, -1), map);
                    break;
                case "e":
                    player.move(new Vec2d(-1, 1), map);
                    break;
                case "z":
                    player.move(new Vec2d(1, -1), map);
                    break;
                case "c":
                    player.move(new Vec2d(1, 1), map);
                    break;
            }

            for (IUnit unit: map.units) {
                if(unit.getType() == "Enemy"){
                    unit.move(map);
                }
            }

            clear();
            map.updateUnits();
            map.render();

            player.print();

            for (String log: log) {
                System.out.println(log);
            }
            log = new ArrayList<String>();

            if (player.hp <= 0 ){
                clear();
                System.out.println("GAME OVER");
                break;
            }

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
