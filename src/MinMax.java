/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/8/12
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinMax {
    private String[] board;
    private String maxToken;
    private String minToken;
    
    public MinMax(String[] board, String maxToken, String minToken) {
        this.board    = board;
        this.maxToken = maxToken;
        this.minToken = minToken;
    }
    
    public int maxMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestSpace = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[i] == null) {
                String[] newBoard = this.board.clone();
                newBoard[i]       = this.maxToken;
                MinMax child      = new MinMax(newBoard, this.maxToken, this.minToken);
                int childValue    = child.minimize();
                if(childValue > bestScore) {
                    bestScore = childValue;
                    bestSpace = i;
                }
            }
        }
        return bestSpace;
    }
    
    public boolean minWins() {
        return heuristic() == Integer.MIN_VALUE;
    }

    public boolean maxWins() {
        return heuristic() == Integer.MAX_VALUE;
    }

    public boolean boardIsFull() {
        for(int i = 0; i < board.length; i++) {
            if(board[i] == null) {
                return false;
            }
        }
        return true;
    }

    private int minimize() {
        if(boardIsFull() || minWins()) {
            return heuristic();
        } else {
            int bestScore = Integer.MAX_VALUE;
            for(int i = 0; i < board.length; i++) {
                if(board[i] == null) {
                    String[] newBoard = this.board.clone();
                    newBoard[i]       = this.minToken;
                    MinMax child      = new MinMax(newBoard, this.maxToken, this.minToken);
                    int childValue    = child.maximize();
                    if(childValue < bestScore) {
                        bestScore = childValue;
                    }
                }
            }
            return bestScore;
        }
    }

    private int maximize() {
        if(boardIsFull() || maxWins()) {
            return heuristic();
        } else {
            int bestScore = Integer.MIN_VALUE;
            for(int i = 0; i < board.length; i++) {
                if(board[i] == null) {
                    String[] newBoard = this.board.clone();
                    newBoard[i]       = this.maxToken;
                    MinMax child      = new MinMax(newBoard, this.maxToken, this.minToken);
                    int childValue    = child.minimize();
                    if(childValue > bestScore) {
                        bestScore = childValue;
                    }
                }
            }
            return bestScore;
        }
    }

    public int heuristic() {
        int score = 0;
        // Check rows
        score = scoreLine(board[0], board[1], board[2], score);
        score = scoreLine(board[3], board[4], board[5], score);
        score = scoreLine(board[6], board[7], board[8], score);
        // Check columns
        score = scoreLine(board[0], board[3], board[6], score);
        score = scoreLine(board[1], board[4], board[7], score);
        score = scoreLine(board[2], board[5], board[8], score);
        // Check diagonals
        score = scoreLine(board[0], board[4], board[8], score);
        score = scoreLine(board[2], board[4], board[6], score);
        return score;
    }
    
    private int scoreLine(String a, String b, String c, int previousScore) {
        if(previousScore == Integer.MAX_VALUE || previousScore == Integer.MIN_VALUE) {
            return previousScore;
        }

        int minTokens = 0;
        int maxTokens = 0;
        if(a == minToken) {
            minTokens++;
        } else if(a == maxToken) {
            maxTokens++;
        }
        if(b == minToken) {
            minTokens++;
        } else if(b == maxToken) {
            maxTokens++;
        }
        if(c == minToken) {
            minTokens++;
        } else if(c == maxToken) {
            maxTokens++;
        }
        if(minTokens == 0 && maxTokens == 0) {
            return previousScore;
        } else if(maxTokens == 3) {
            return Integer.MAX_VALUE;
        } else if(minTokens == 3) {
            return Integer.MIN_VALUE;
        } else if(minTokens == 0) {
            return previousScore + maxTokens;
        } else if(maxTokens == 0) {
            return previousScore - minTokens;
        } else {
            return previousScore;
        }
    }
}
