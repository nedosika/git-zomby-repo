import com.sun.javafx.geom.Vec2d;

import java.util.ArrayList;

/**
 * Created by Павел on 12.05.2017.
 */
public class Map {
    public IUnit[][] map;
    int rows;
    int cols;

    public ArrayList<IUnit> units  = new ArrayList<>();

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        map = new IUnit[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if (Math.random() > 0.8){
                    map[i][j] = new Wall();
                }
                else{
                    map[i][j] = new Empty();
                }
            }
        }
    }

    public void render() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j].getSprite());
            }
            System.out.println();
        }
    }

    public void addUnit(IUnit unit) {
        addUnit(unit, genRndPos());
    }

    public void addUnit(IUnit unit, Vec2d position) {
        unit.setPosition(position);
        map[(int)position.x][(int)position.y] = unit;
        units.add(unit);
    }

    public Vec2d genRndPos() {
        int x = (int)(Math.random() * this.rows);
        int y = (int)(Math.random() * this.cols);

        while (!(map[x][y] instanceof Empty)){
            x = (int)(Math.random() * this.rows);
            y = (int)(Math.random() * this.cols);
        }

        return new Vec2d(x, y);
    }

}
