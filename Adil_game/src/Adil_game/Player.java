/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */
package Adil_game;

import java.util.Scanner;

public class Player {
    private Scanner scanner;
    private Board board;
    private Ship[] ships;
    private long startTime;
    
    public Player() {
        scanner = new Scanner(System.in);
        board = new Board();
        ships = new Ship[3];
        ships[0] = new Ship(1);
        ships[1] = new Ship(2);
        ships[2] = new Ship(2);
        ships[0].setPosition(2, 3, false);
        ships[1].setPosition(5, 2, true);
        ships[2].setPosition(7, 6, false);
        startTime = 0;
    }
    
    public void play() {
        boolean gameFinished = false;
        int numShips = ships.length;
        long timeTaken = 0;
        startTime = System.currentTimeMillis();
        board.display();
        while (!gameFinished) {
            String input = getInput();
            int row = input.charAt(1) - '1';
            int col = input.charAt(0) - 'A';
            boolean hit = false;
            for (int i = 0; i < ships.length; i++) {
                if (ships[i].isHit(row, col)) {
                    hit = true;
                    board.getBoardState()[ships[i].getRow()][ships[i].getCol()] = 'X';
                    if (ships[i].isSunk()) {
                        numShips--;
                        markDestroyedShip(i);
                    }
                }
            }
            if (hit) {
                board.getBoardState()[row][col] = 'U';
            } else {
                board.getBoardState()[row][col] = 'o';
            }
            board.display();
            if (numShips == 0) {
                gameFinished = true;
                timeTaken = (System.currentTimeMillis() - startTime) / 1000;
                System.out.println("Поздравляем! Вы выиграли! Время: " + timeTaken + " секунд");
            }
        }
    }
    
    public String getInput() {
        System.out.print("Куда стреляем? ");
        String input = scanner.nextLine();
        long currentTime = System.currentTimeMillis();
        while (input.isEmpty() && currentTime - startTime < 15000) {
            input = scanner.nextLine();
        }
        if (input.isEmpty()) {
            System.out.println("Слишком долго! Вы проиграли.");
            System.exit(0);
        }
        return input.toUpperCase();
    }
    
    public void markDestroyedShip(int shipIndex) {
        int row = ships[shipIndex].getRow();
        int col = ships[shipIndex].getCol();
        boolean isVertical = ships[shipIndex].isVertical();
        int length = ships[shipIndex].getLength();
        for (int i = 0; i < length; i++) {
            if (isVertical) {
                if (col > 0) {
                    board.getBoardState()[row + i][col - 1] = 'o';
                }
                if (col < 7) {
                    board.getBoardState()[row + i][col + 1] = 'o';
                }
            } else {
                if (row > 0) {
                    board.getBoardState()[row - 1][col + i] = 'o';
                }
                if (row < 7) {
                    board.getBoardState()[row + 1][col + i] = 'o';
                }
            }
        }
    }
    
    public void printTop3Scores() {
    }
}
/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */
