import com.sun.javafx.geom.Vec2d;

/**
 * Created by Павел on 12.05.2017.
 */
public class Map {
    public String[][] map;
    int rows;
    int cols;

    public Map(int rows, int cols){
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

    public void render(Player player) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( player.position.equals( new Vec2d(i, j) ) ) {
                    System.out.print(player.sprite);
                }
                else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    public Vec2d genRndPos(){
        int x = (int)(Math.random() * this.rows);
        int y = (int)(Math.random() * this.cols);

        while (map[x][y] == "#"){
            x = (int)(Math.random() * this.rows);
            y = (int)(Math.random() * this.cols);
        }

        //System.out.println("x="+x+", y="+y);
        return new Vec2d(x, y);
    }

}
