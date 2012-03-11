import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/8/12
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinMaxTest {
    protected String[] board = {null, null, null, null, null, null, null, null, null};
    
    @Test
    public void testProperOpeningMove() {
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        Move[] acceptableMoves = {new Move(0, 0),
                                  new Move(0, 2),
                                  new Move(1, 1),
                                  new Move(2, 0),
                                  new Move(2, 2)};
        assert(inSet(acceptableMoves, minMaxPlayer.nextMove()));
    }

    @Test
    public void testMinPlayerGetsMinusOnePointPerUnblockedLinePerToken() {
        board[0] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assertEquals(-3, minMaxPlayer.heuristic());
    }

    @Test
    public void testMaxPlayerGetsOnePointPerUnblockedLinePerToken() {
        board[0] = "X";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assertEquals(3, minMaxPlayer.heuristic());
    }

    @Test
    public void testNoPointsAwardedForLinesContainingTokensFromEachPlayer() {
        board[0] = "O";
        board[1] = "X";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assertEquals(-1, minMaxPlayer.heuristic());
    }

    @Test
    public void testMinPlayerGetsMinusTwoPointsForTwoTokensOnTheSameLine() {
        board[0] = "O";
        board[1] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assertEquals(-5, minMaxPlayer.heuristic());
    }

    @Test
    public void testAWinForMaxPlayerIsWorthMaximumPoints() {
        board[0] = "X";
        board[1] = "X";
        board[2] = "X";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assertEquals(Integer.MAX_VALUE, minMaxPlayer.heuristic());
    }

    @Test
    public void testTakesCenterWhenOpponentTakesCorner() {
        board[0] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        Move[] acceptableMoves = {new Move(1, 1)};
        assert(inSet(acceptableMoves, minMaxPlayer.nextMove()));
    }

    public boolean inSet(Move[] set, Move move) {
        for(int i = 0; i < set.length; i++) {
            if(set[i].equals(move)) {
                return true;
            }
        }
        return false;
    }

    protected void setUp() {
        for(int i = 0; i < board.length; i++) {
            board[i] = null;
        }
    }
}
