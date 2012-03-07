import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/7/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserInputTests {
    @Test
    public void testMoveInTopLeftCorner() {
        Move usersMove = makeMove("a1\n");
        assertEquals(0, usersMove.getRow());
        assertEquals(0, usersMove.getColumn());
    }
    
    @Test
    public void testMoveInCenter() {
        Move usersMove = makeMove("b2\n");
        assertEquals(1, usersMove.getColumn());
        assertEquals(1, usersMove.getRow());
    }
    
    @Test
    public void testInvalidInputFollowedByValidInput() {
        Move usersMove = makeMove("h9c3\n");
        assertEquals(2, usersMove.getRow());
        assertEquals(2, usersMove.getColumn());
    }
    
    private Move makeMove(String inputString) {
        Scanner userInput = new Scanner(inputString);
        UserInput input   = new UserInput(userInput);
        return input.nextMove();
    }
}
