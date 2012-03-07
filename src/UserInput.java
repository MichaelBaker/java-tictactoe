import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: michaelbaker
 * Date: 3/7/12
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserInput {
    private Scanner inputStream;
    private final Pattern rowPattern = Pattern.compile("[abc]");
    private final Pattern columnPattern = Pattern.compile("[123]");

    public UserInput(Scanner inputStream) {
      this.inputStream = inputStream;
    }

    public Move nextMove() {
        String column = null;
        String row = null;
        do {
          String line = this.inputStream.nextLine();
          column = getColumnToken(line);
          row = getRowToken(line);
        } while(column == null || row == null);

        return new Move(encodeRow(row), encodeColumn(column));
    }
    
    private String getColumnToken(String line) {
        Matcher matcher = columnPattern.matcher(line);
        matcher.find();
        return matcher.group();
    }
    
    private String getRowToken(String line) {
        Matcher matcher = rowPattern.matcher(line);
        matcher.find();
        return matcher.group();
    }
    
    private int encodeRow(String row) {
        if(row.equals("a")) {
            return 0;
        } else if(row.equals("b")) {
         return 1;
        } else if(row.equals("c")) {
            return 2;
        } else {
            return 0;
        }
    }
    
    private int encodeColumn(String column) {
        if(column.equals("1")) {
            return 0;
        } else if(column.equals("2")) {
            return 1;
        } else if(column.equals("3")) {
            return 2;
        } else {
            return -1;
        }
    }
}
