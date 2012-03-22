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
        String invalidMoveText    = "Invalid space:";
        String enterMoveText      = "Enter your move:";
        String welcomeText        = "Welcome to the Gentleman's game of TicTacToe";
        String gameOverText       = "~ Game Over ~";
        String playerOneToken     = "X";
        String playerTwoToken     = "O";

        Game game                 = new Game(playerOneToken, playerTwoToken);
        ScreenFormatter formatter = new ScreenFormatter();
        UserInput input           = new UserInput(new Scanner(System.in), System.out, invalidMoveText);
        
        System.out.println(welcomeText);
        
        while(!game.isFinished()) {
            System.out.println(formatter.board(game.boardToArray()));
            System.out.print(enterMoveText);
            Move humanMove = input.nextMove();
            while(!game.isValidMove(humanMove)) {
                System.out.print(invalidMoveText);
                humanMove = input.nextMove();
            }
            game.placePlayerOneToken(humanMove);
            MinMaxPlayer computer = new MinMaxPlayer(game.boardToArray(), playerTwoToken, playerOneToken);
            if(computer.isTie()) { break; }
            game.placePlayerTwoToken(computer.nextMove());
        }

        System.out.println(gameOverText);
        System.out.println(formatter.board(game.boardToArray()));
    }
}
