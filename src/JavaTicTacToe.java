import com.sun.servicetag.SystemEnvironment;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/7/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class JavaTicTacToe {
    public static void main(String[] args) {
        Game game       = new Game();
        UserInput input = new UserInput(new Scanner(System.in));
        
        System.out.println("Welcome to the Gentleman's game of TicTacToe");
    }
}
