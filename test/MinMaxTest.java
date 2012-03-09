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
        MinMax minMax         = new MinMax(board, "X", "O");
        int[] acceptableMoves = {0, 2, 4, 6, 7};
        assert(inSet(acceptableMoves, minMax.maxMove()));
    }

    @Test
    public void testHeuristic1() {
        board[0]      = "O";
        MinMax minMax = new MinMax(board, "X", "O");
        assertEquals(-3, minMax.heuristic());
    }

    @Test
    public void testHeuristic2() {
        board[0]      = "X";
        MinMax minMax = new MinMax(board, "X", "O");
        assertEquals(3, minMax.heuristic());
    }

    @Test
    public void testHeuristic3() {
        board[0]      = "O";
        board[1]      = "X";
        MinMax minMax = new MinMax(board, "X", "O");
        assertEquals(-1, minMax.heuristic());
    }

    @Test
    public void testHeuristic4() {
        board[0]      = "O";
        board[1]      = "O";
        MinMax minMax = new MinMax(board, "X", "O");
        assertEquals(-5, minMax.heuristic());
    }

    @Test
    public void testHeuristic5() {
        board[0]      = "X";
        board[1]      = "X";
        board[2]      = "X";
        MinMax minMax = new MinMax(board, "X", "O");
        assertEquals(Integer.MAX_VALUE, minMax.heuristic());
    }

    @Test
    public void testTakesCenterWhenOpponentTakesCorner() {
        board[0]              = "O";
        MinMax minMax         = new MinMax(board, "X", "O");
        int[] acceptableMoves = {4};
        assert(inSet(acceptableMoves, minMax.maxMove()));
    }

    public boolean inSet(int[] set, int move) {
        for(int i = 0; i < set.length; i++) {
            if(set[i] == move) {
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
