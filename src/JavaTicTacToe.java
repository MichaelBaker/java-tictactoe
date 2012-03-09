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
        UserInput input = new UserInput(new Scanner(System.in), System.out, "Invalid space:");
        
        System.out.println("Welcome to the Gentleman's game of TicTacToe");
        
        while(!game.isFinished()) {
            System.out.println(game);
            Move humanMove = null;
            System.out.print("Enter your move:");
            humanMove = input.nextMove();
            while(!game.isValidMove(humanMove)) {
                System.out.print("Invalid space:");
                humanMove = input.nextMove();
            }
            game.placeXToken(humanMove);
            MinMax computer = new MinMax(game.boardToArray(), "O", "X");
            game.placeOToken(computer.maxMove());
        }
        System.out.println("~ Game Over ~");
        System.out.println(game);
    }
}
