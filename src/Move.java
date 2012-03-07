/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/7/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Move {
    private int row;
    private int column;

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public int getRow() {
      return this.row;  
    }
    
    public int getColumn() {
        return this.column;
    }
}
