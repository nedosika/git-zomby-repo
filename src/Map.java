
/**
 * Created by Павел on 12.05.2017.
 */
public class Map {
    public String[][] map;

    public Map(int x, int y){
        map = new String[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++) {
                if (Math.random() > 0.8){
                    map[i][j] = "#";
                }
                else{
                    map[i][j] = ".";
                }
            }
        }
    }

    public void render(){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
