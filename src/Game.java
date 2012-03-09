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
        return "  a b c\n" +
               "1 " + tokenToString(board[0]) + " " + tokenToString(board[1]) + " " + tokenToString(board[2]) + "\n" +
               "2 " + tokenToString(board[3]) + " " + tokenToString(board[4]) + " " + tokenToString(board[5]) + "\n" +
               "3 " + tokenToString(board[6]) + " " + tokenToString(board[7]) + " " + tokenToString(board[8]);
    }
    
    private String tokenToString(String token) {
        if(token == null) {
            return " ";
        } else {
            return token;
        }
    }
    
    public Game() {
        this.board = new String[9];
    }
    
    public String[] boardToArray() {
        return board;
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

    public void placeOToken(int i) {
        this.board[i] = "O";
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
