/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */
package Adil_game;
	public class Board {
	    private char[][] field = new char[8][8];
	    
	    public Board() {
	        for (int row = 0; row < 8; row++) {
	            for (int col = 0; col < 8; col++) {
	                field[row][col] = ' ';
	            }
	        }
	    }
	    
	    public void display() {
	        System.out.println("   A B C D E F G H");
	        for (int row = 0; row < 8; row++) {
	            System.out.print((row + 1) + "  ");
	            for (int col = 0; col < 8; col++) {
	                System.out.print(field[row][col] + " ");
	            }
	            System.out.println();
	        }
	    }
	    
	    public void setBoardState(char[][] state) {
	        field = state;
	    }
	    
	    public char[][] getBoardState() {
	        return field;
	    }
	}
/**
* Бактыбеков Адиль ПКС - 1 - 20
*/