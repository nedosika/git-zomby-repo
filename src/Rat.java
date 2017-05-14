import com.sun.javafx.geom.Vec2d;

/**
 * Created by nedos on 12.05.2017.
 */
public class Rat extends Unit {

    public Rat(String name, int max_hp, String type, int level) {
        super(name, max_hp, type, (char)27 + "[31m" + "r" + (char)27 + "[0m", level);
        Game.log.add(name + " Добавлен в игру");
    }

}
