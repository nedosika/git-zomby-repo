/**
 * Created by Павел on 12.05.2017.
 */
public class Weapon {
    String name;
    String sprite;
    int min_damage;
    int max_damage;
    int weight;

    public Weapon(String name, String sprite, int max_damage, int min_damage, int weight){
        this.name = name;
        this.sprite = sprite;
        this.max_damage = max_damage;
        this.min_damage = min_damage;
        this.weight = weight;
    }
}
