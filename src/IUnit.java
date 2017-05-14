import com.sun.javafx.geom.Vec2d;

import java.util.ArrayList;

/**
 * Created by nedos on 13.05.2017.
 */
public interface IUnit {

    Vec2d getPosition();

    String getSprite();

    String getType();

    void setPosition(Vec2d position);

    boolean move(Vec2d dir, Map map);

    boolean move(Map map);

    void addDamage(int damage, ArrayList map);

    void attack(IUnit target, ArrayList map);

}
