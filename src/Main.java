import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Павел on 12.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        menu();
        Scanner in = new Scanner(System.in);
        String key = in.nextLine();

        while (!key.equals("q")) {

            switch (key){
                case "1":
                    Game game = new Game();
            }
            menu();
            key = in.nextLine();
        }
    }

    static void menu(){
        System.out.println("1. Новая игра ");
        System.out.println("2. Сохранить ");
        System.out.println("3. Загрузить ");
        System.out.println("4. Настройки ");
        System.out.println("q. Выход ");
        System.out.println("Введите команду: ");
    }
}
