import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Unit implements IUnit{
    public String name;
    public int hp;
    public int max_hp;
    public int level;
    public Vec2d position;
    public String sprite;
    public String type;

    public Unit(String name, int max_hp, String type, String sprite, int level){
        this.name = name;
        this.hp = max_hp;
        this.max_hp = max_hp;
        this.level = level;
        this.type = type;
        this.sprite = sprite;
    }

    public void move(Vec2d dir, Map map) {
        int curX = (int)(this.position.x + dir.x);
        int curY = (int)(this.position.y + dir.y);

        if (curX >= 0 && curX < map.rows && curY >= 0 && curY < map.cols) {
            if(map.map[curX][curY] == ".") {
                map.map[(int)(this.position.x)][(int)(this.position.y)] = ".";
                this.position.x += dir.x;
                this.position.y += dir.y;
            }
        }
    }

    public void print(){
        System.out.println("Имя: " + name + "[" + level + "]" + "HP: " + hp + "/" + max_hp + " pos[" + (int)position.x + "/" + (int)position.y + "]");
    }

    public Vec2d getPosition(){
        return position;
    }

    public String getSprite(){
        return sprite;
    }

    public void setPosition(Vec2d position){
        this.position = position;
    }


    static public Vec2d spawn(Map map) {
        int x = (int) (Math.random() * map.rows);
        int y = (int) (Math.random() * map.cols);

        while (map.map[x][y] != ".") {
            x = (int) (Math.random() * map.rows);
            y = (int) (Math.random() * map.cols);
        }

        return new Vec2d(x, y);
    }

}
