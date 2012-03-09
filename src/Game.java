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
    private String playerOneToken;
    private String playerTwoToken;

    public String toString() {
        return "[" + StringUtils.join(board, ", ") + "]";
    }
    
    public Game(String playerOneToken, String playerTwoToken) {
        this.board          = new String[9];
        this.playerOneToken = playerOneToken;
        this.playerTwoToken = playerTwoToken;
    }
    
    public String[] boardToArray() {
        return board;
    }

    public boolean isValidMove(Move space) {
        return tokenAt(space) == null;
    }
    
    public void placePlayerOneToken(Move space) {
        int index = convertMoveToIndex(space);
        this.board[index] = this.playerOneToken;
    }
    
    public void placePlayerTwoToken(Move space) {
        int index = convertMoveToIndex(space);
        this.board[index] = this.playerTwoToken;
    }

    public String tokenAt(Move space) {
        int index = convertMoveToIndex(space);
        return this.board[index];
    }

    public boolean isFinished() {
        return
        // Check rows
        isWinningLine(board[0], board[1], board[2]) ||
        isWinningLine(board[3], board[4], board[5]) ||
        isWinningLine(board[6], board[7], board[8]) ||
        // Check columns
        isWinningLine(board[0], board[3], board[6]) ||
        isWinningLine(board[1], board[4], board[7]) ||
        isWinningLine(board[2], board[5], board[8]) ||
        // Check diagonals
        isWinningLine(board[0], board[4], board[8]) ||
        isWinningLine(board[2], board[4], board[6]) ||
        boardFull();
    }
    
    private boolean isWinningLine(String a, String b, String c) {
        return a == b && b == c && a != null;
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
