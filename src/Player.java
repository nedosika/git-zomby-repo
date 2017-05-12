import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Player extends Unit {
    public int expirience;

    public Player(String name, int hp, Vec2d position, String type) {
        super(name, hp, position, type);
        this.expirience = 0;
    }
}
