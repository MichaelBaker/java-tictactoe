import org.apache.commons.lang3.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/7/12
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private String[] board;

    public String toString() {
        return StringUtils.join(board, ", ");
    }
    
    public Game() {
        this.board = new String[9];
    }
    
    public boolean isValidMove(Move space) {
        return tokenAt(space) == null;
    }
    
    public void placeXToken(Move space) {
        int index = convertMoveToIndex(space);
        this.board[index] = "X";
    }
    
    public void placeOToken(Move space) {
        int index = convertMoveToIndex(space);
        this.board[index] = "O";
    }

    public String tokenAt(Move space) {
        int index = convertMoveToIndex(space);
        return this.board[index];
    }

    public boolean isFinished() {
        return boardFull();
    }

    public boolean XWins() {
        return false;
    }

    private boolean boardFull() {
        for(int i = 0; i < board.length; i++) {
            if(this.board[i] == null) {
                return false;
            }
        }
        return true;
    }
    
    private int convertMoveToIndex(Move space) {
        return space.getRow()*3 + space.getColumn();
    }
}
