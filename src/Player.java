import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Player extends Unit {
    public int expirience;

    public Player(String name, int max_hp, String type, String sprite, int level, String status) {
        super(name, max_hp, type, sprite, level, status);
        this.expirience = 0;
        Game.log.add(name + " вошел в бой");
    }

}
