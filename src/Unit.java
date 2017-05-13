import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Unit implements IUnit {
    public String name;
    public int hp;
    public int max_hp;
    public int level;
    public Vec2d position;
    public String sprite;
    public String type;

    public Unit(String name, int max_hp, String type, String sprite, int level) {
        this.name = name;
        this.hp = max_hp;
        this.max_hp = max_hp;
        this.level = level;
        this.type = type;
        this.sprite = sprite;
    }

    public boolean move(Vec2d dir, Map map) {
        Vec2d newPos = new Vec2d(position.x + dir.x, position.y + dir.y);

        if (newPos.x >= 0 && newPos.x < map.rows && newPos.y >= 0 && newPos.y < map.cols) {
            if(map.map[(int)newPos.x][(int)newPos.y] == ".") {
                map.map[(int)(position.x)][(int)(position.y)] = ".";
                position = newPos;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean move(Map map) {

        while(!move(genRndDir(), map)){

        }
        return true;
    }

    public void print() {
        System.out.println("Имя: " + name + "[" + level + "]" + "HP: " + hp + "/" + max_hp + " pos[" + (int)position.x + "/" + (int)position.y + "]");
    }

    public Vec2d getPosition() {
        return position;
    }

    public String getSprite() {
        return sprite;
    }

    public String getType() {
        return type;
    }

    public void setPosition(Vec2d position) {
        this.position = position;
    }

    static public Vec2d genRndDir() {
        int rnd = (int)(Math.random() * 8);
        Vec2d dir = new Vec2d(0,0);
        switch (rnd){
            case 0:
                dir = new Vec2d( 1, 0);
                break;
            case 1:
                dir = new Vec2d( -1, 0);
                break;
            case 2:
                dir =new Vec2d( 0, 1);
                break;
            case 3:
                dir = new Vec2d( 0, -1);
                break;
            case 4:
                dir = new Vec2d( 1, 1);
                break;
            case 5:
                dir = new Vec2d( -1, -1);
                break;
            case 6:
                dir = new Vec2d( 1, -1);
                break;
            case 7:
                dir = new Vec2d( -1, 1);
                break;
        }
        return dir;
    }
}
