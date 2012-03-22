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
    public void testBlocksHorizontalWin() {
        board[0] = "X";
        board[1] = "X";
        board[4] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "O", "X");
        Move move = minMaxPlayer.nextMove();
        assertEquals(0, move.getRow());
        assertEquals(2, move.getColumn());
    }
    
    @Test
    public void testAWinForMaxPlayer() {
        board[0] = "X";
        board[1] = "X";
        board[2] = "X";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assert(minMaxPlayer.maxWins());
    }

    @Test
    public void testAWinForMinPlayer() {
        board[0] = "O";
        board[1] = "O";
        board[2] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assert(minMaxPlayer.minWins());
    }

    @Test
    public void testTie() {
        board[0] = "X"; board[1] = "O"; board[2] = "X";
        board[3] = "O"; board[4] = "O"; board[5] = "X";
        board[6] = "X"; board[7] = "X"; board[8] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        assert(minMaxPlayer.isTie());
    }

    @Test
    public void testTakesCenterWhenOpponentTakesCorner() {
        board[0] = "O";
        MinMaxPlayer minMaxPlayer = new MinMaxPlayer(board, "X", "O");
        Move[] acceptableMoves = {new Move(1, 1)};
        Move move = minMaxPlayer.nextMove();
        assert(inSet(acceptableMoves, minMaxPlayer.nextMove()));
    }

    @Test
    public void testOpponentCornerStrategy() {
        board[0] = board[2] = board[8] = "X";
        board[1] = board[3] = board[4] = "O";
        MinMaxPlayer player = new MinMaxPlayer(board, "O", "X");
        Move newMove = player.nextMove();
        assertEquals(1, newMove.getRow());
        assertEquals(2, newMove.getColumn());
    }

    @Test
    public void testSideWin() {
        board[0] = board[2] = board[8] = board[5] = "X";
        board[1] = board[3] = board[4] = "O";
        MinMaxPlayer player0 = new MinMaxPlayer(board, "X", "O");
        MinMaxPlayer player1 = new MinMaxPlayer(board, "O", "X");
        assert(player0.maxWins());
        assert(player1.minWins());
    }

    @Test
    public void testTakesTheWin() {
        board[0] = board[2] = board[8] = "X";
        board[1] = board[4] = "O";
        MinMaxPlayer player = new MinMaxPlayer(board, "O", "X");
        Move newMove = player.nextMove();
        assertEquals(2, newMove.getRow());
        assertEquals(1, newMove.getColumn());
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
