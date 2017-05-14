import com.sun.javafx.geom.Vec2d;

import java.util.ArrayList;

/**
 * Created by Павел on 12.05.2017.
 */
public class Map {
    public String[][] map;
    int rows;
    int cols;

    public ArrayList<IUnit> units  = new ArrayList<>();

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        map = new String[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if (Math.random() > 0.8){
                    map[i][j] = "#";
                }
                else{
                    map[i][j] = ".";
                }
            }
        }
    }

    public void render() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (IUnit unit: units) {
                    if (unit.getPosition().equals(new Vec2d(i, j))){
                        if (!unit.getSprite().equals("@")){
                            map[i][j] = (char)27 + "[31m" + unit.getSprite()  + (char)27 + "[0m";
                        }
                        else{

                            map[i][j] = (char)27 + "[32m" + unit.getSprite()  + (char)27 + "[0m";
                        }
                    }
                }
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void addUnit(IUnit unit) {
        addUnit(unit, genRndPos());
    }

    public void addUnit(IUnit unit, Vec2d position) {
        unit.setPosition(position);
        units.add(unit);
    }



    public IUnit getUnit(Vec2d position){
        for (int i = 0; i < units.size(); i ++ ) {
            if(units.get(i).getPosition() == position){

                return units.get(i);
            }
        }
        return units.get(1);
     }


    public void updateUnits() {
        int i = 0;
        while (i < units.size()) {
            if (units.get(i).getHp() <= 0) {
                map[(int)units.get(i).getPosition().x][(int)units.get(i).getPosition().y] = ".";
                Game.log.add(units.get(i) + " умирет");
                units.remove(i);
            }
            i++;
        }
    }


    public Vec2d genRndPos() {
        int x = (int)(Math.random() * this.rows);
        int y = (int)(Math.random() * this.cols);

        while (map[x][y] != "." ){
            x = (int)(Math.random() * this.rows);
            y = (int)(Math.random() * this.cols);
        }

        return new Vec2d(x, y);
    }

}
