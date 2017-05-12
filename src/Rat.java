import com.sun.javafx.geom.Vec2d;

/**
 * Created by nedos on 12.05.2017.
 */
public class Rat extends Unit {

    public Rat(String name, int max_hp, Vec2d position, String type, String sprite) {
        super(name, max_hp, position, type, sprite);
    }

    static public Rat spawn(Map map, int size){
        int x = (int)(Math.random() * map.rows);
        int y = (int)(Math.random() * map.cols);

        while (map.map[x][y] != "."){
            x = (int)(Math.random() * map.rows);
            y = (int)(Math.random() * map.cols);
        }

        int level = (int)Math.random() * 10;

        return new Rat("Rat_" + String.valueOf(size), level * 10, new Vec2d(x,y), "Enemy", "r" );
    }
}
