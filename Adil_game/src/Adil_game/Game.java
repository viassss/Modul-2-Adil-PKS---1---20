/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */

package Adil_game;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player();
        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("1. Новая игра");
            System.out.println("2. Результаты");
            System.out.println("3. Выход");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    player.play();
                    break;
                case 2:
                    player.printTop3Scores();
                    break;
                case 3:
                    gameFinished = true;
                    break;
            }
        }
    }
}
/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */