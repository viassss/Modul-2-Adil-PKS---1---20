/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */
package Adil_game;

public class Ship {
    private int length;
    private int hits;
    private boolean isVertical;
    private int row;
    private int col;
    
    public Ship(int length) {
        this.length = length;
        hits = 0;
        isVertical = true;
    }
    
    public void setPosition(int row, int col, boolean isVertical) {
        this.row = row;
        this.col = col;
        this.isVertical = isVertical;
    }
    
    public boolean isHit(int row, int col) {
        if (!isVertical && this.row == row) {
            int start = Math.min(col, this.col);
            int end = Math.max(col, this.col);
            if (start + length <= end) {
                return false;
            }
            if (this.col == start + length - 1) {
                hits++;
                return true;
            }
        } else if (isVertical && this.col == col) {
            int start = Math.min(row, this.row);
            int end = Math.max(row, this.row);
            if (start + length <= end) {
                return false;
            }
            if (this.row == start + length - 1) {
                hits++;
                return true;
            }
        }
        return false;
    }
    
    public boolean isSunk() {
        return hits == length;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean isVertical() {
        return isVertical;
    }
}
/**
 * Бактыбеков Адиль ПКС - 1 - 20
 */
