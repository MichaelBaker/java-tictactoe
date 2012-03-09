/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/9/12
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScreenFormatter {
    public String board(String[] board) {
        return "  a b c\n" +
                "1 " + tokenToString(board[0]) + " " + tokenToString(board[1]) + " " + tokenToString(board[2]) + "\n" +
                "2 " + tokenToString(board[3]) + " " + tokenToString(board[4]) + " " + tokenToString(board[5]) + "\n" +
                "3 " + tokenToString(board[6]) + " " + tokenToString(board[7]) + " " + tokenToString(board[8]);
    }

    private String tokenToString(String token) {
        if(token == null) {
            return " ";
        } else {
            return token;
        }
    }
}
