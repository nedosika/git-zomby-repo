import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Unit {
    public String name;
    public int hp;
    public int level;
    public Vec2d position;
    public String sprite;
    public String type;

    public Unit(String name, int hp, Vec2d position, String type, String sprite){
        this.name = name;
        this.hp = hp;
        this.level = 1;
        this.position = position;
        this.type = type;
        this.sprite = sprite;
    }

    public void move(Vec2d dir) {
        this.position.x += dir.x;
        this.position.y += dir.y;
    }

}
