import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/7/12
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameTest {
    @Test
    public void testAllSpacesValidOnAnEmptyBoard() {
        Game game = new Game();
        for(int i = 0; i < 3; i++) {
            for(int n = 0; n < 3; n++) {
                assert(game.isValidMove(new Move(i, n)));
            }
        }
    }
    
    @Test
    public void testPlaceXTokenOnEmptySpace() {
        Game game = new Game();
        game.placeXToken(new Move(0, 0));
        assertEquals("X", game.tokenAt(new Move(0, 0)));
    }

    @Test
    public void testFilledSpacesAreInvalid() {
        Game game = new Game();
        game.placeXToken(new Move(0, 0));
        assert(!game.isValidMove(new Move(0, 0)));
    }
    
    @Test
    public void testPlacingATokenOnATakenSpaceChangesTheToken() {
        Game game = new Game();
        game.placeXToken(new Move(0, 0));
        game.placeOToken(new Move(0, 0));
        assertEquals("O", game.tokenAt(new Move(0, 0)));
    }
    
    @Test
    public void testNewGameIsNotFinished() {
        Game game = new Game();
        assert(!game.isFinished());
    }
    
    @Test
    public void testGameIsFinishedIfBoardIsFull() {
        Game game = new Game();
        for(int i = 0; i < 3; i++) {
            for(int n = 0; n < 3; n++) {
                game.placeXToken(new Move(i, n));
            }
        }
        assert(game.isFinished());
    }
    
    @Test
    public void testXDoesNotWinWithAnEmptyBoard() {
        Game game = new Game();
        assert(!game.XWins());
    }
}
