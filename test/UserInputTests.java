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
        Scanner userInput = new Scanner("a1\n");
        UserInput input   = new UserInput(userInput);
        Move usersMove    = input.nextMove();
        assertEquals(0, usersMove.getRow());
        assertEquals(0, usersMove.getColumn());
    }
    
    @Test
    public void testMoveInCenter() {
        Scanner userInput = new Scanner("b2\n");
        UserInput input   = new UserInput(userInput);
        Move usersMove    = input.nextMove();
        assertEquals(1, usersMove.getColumn());
        assertEquals(1, usersMove.getRow());
    }
}
