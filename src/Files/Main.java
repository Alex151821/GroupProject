package Files;
import java.io.Serializable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Files.Checkers checkers = new Files.Checkers();
        Files.Stuff stuff = new Files.Stuff();
        Scanner scan = new Scanner(System.in);
        //Integer [][] board = init();
        // I also made an init(), you can also do this:
        Integer[][] board2 = checkers.initBoard(8);
        //checkers.printBoard(board);
        checkers.printBoard(board2);
        stuff.print("Enter form x");

        stuff.print("Enter form y");
        stuff.print("Enter to x");
        stuff.print("Enter to y");

        Serializable[] out = checkers.movePiece(board2, 0, 2, 1, 3, 2);
        board2 = (Integer[][]) out[0];
        stuff.print((String) out[1]);
        checkers.printBoard(board2);
        out = checkers.movePiece(board2, 1, 3, 2, 2, 2);
        board2 = (Integer[][]) out[0];
        stuff.print((String) out[1]);
        checkers.printBoard(board2);
        scan.close();

    }

    /*
    //unnecessary
    public static Integer[][] init(){
        Integer [][] board = new Integer[8][8];
        Integer [] board0 = {0, 1, 0, 1, 0, 1, 0, 1};
        Integer [] board1 = {1, 0, 1, 0, 1, 0, 1, 0};
        for (Integer i = 0; i < board.length; i++){
            if (i % 2 == 0){
                board[i] = board0;
            } else{
                board[i] = board1;
            }
        }
        return board;
    }
*/
}