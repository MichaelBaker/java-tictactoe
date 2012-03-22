/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/8/12
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinMaxPlayer {
    private String[] board;
    private String maxToken;
    private String minToken;
    private int value;
    private boolean valueSet = false;
    
    public MinMaxPlayer(String[] board, String maxToken, String minToken) {
        this.board    = board;
        this.maxToken = maxToken;
        this.minToken = minToken;
    }

    public Move nextMove() {
        Move bestMove  = null;
        int  bestValue = -2;
        for(int i = 0; i < board.length; i++) {
            if(board[i] != null) { continue; }
            MinMaxPlayer child = makeChild(i);
            if(child.minWins()) { return convertIndexToMove(i); }
            if(bestMove == null || -child.value() > bestValue) {
                bestValue = -child.value();
                bestMove  = convertIndexToMove(i);
            }
        }
        return bestMove;
    }

    private int value() {
        if(valueSet)  { return value; }
        if(isTie())   { return 0; }
        if(maxWins()) { return 1; }
        if(minWins()) { return -1; }
        int bestValue = -2;
        for(int i = 0; i < board.length; i++) {
            if(board[i] != null) { continue; }
            MinMaxPlayer child = makeChild(i);
            if(child.minWins()) { return 1; }
            if(-child.value() > bestValue) { bestValue = -child.value(); }
        }
        valueSet = true;
        value    = bestValue;
        return value;
    }

    public MinMaxPlayer makeChild(int index) {
        String[] newBoard = board.clone();
        newBoard[index]   = maxToken;
        return new MinMaxPlayer(newBoard, minToken, maxToken);
    }

    public boolean minWins() {
        return anyFullLinesFor(minToken);
    }

    public boolean maxWins() {
        return anyFullLinesFor(maxToken);
    }

    public boolean isTie() {
        return boardIsFull() && !minWins() && !maxWins();
    }

    public boolean boardIsFull() {
        for(int i = 0; i < board.length; i++) {
            if(board[i] == null) { return false; }
        }
        return true;
    }

    private Move convertIndexToMove(int i) {
        int row = i / 3;
        int column = i % 3;
        return new Move(row, column);
    }
    
    private boolean anyFullLinesFor(String token) {
        return (token.equals(board[0]) && token.equals(board[1]) && token.equals(board[2])) ||
               (token.equals(board[3]) && token.equals(board[4]) && token.equals(board[5])) ||
               (token.equals(board[6]) && token.equals(board[7]) && token.equals(board[8])) ||
               (token.equals(board[0]) && token.equals(board[3]) && token.equals(board[6])) ||
               (token.equals(board[1]) && token.equals(board[4]) && token.equals(board[7])) ||
               (token.equals(board[2]) && token.equals(board[5]) && token.equals(board[8])) ||
               (token.equals(board[0]) && token.equals(board[4]) && token.equals(board[8])) ||
               (token.equals(board[2]) && token.equals(board[4]) && token.equals(board[6]));
    }
}
