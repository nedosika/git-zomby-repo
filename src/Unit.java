import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Unit {
    public String name;
    public int hp;
    public int level;
    public Vec2d position;
    public String type;

    public Unit(String name, int hp, Vec2d position, String type){
        this.name = name;
        this.hp = hp;
        this.level = 1;
        this.position = position;
        this.type = type;
    }

}
