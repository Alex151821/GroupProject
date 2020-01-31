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
        //checkers.printBoard(board);
        checkers.printBoard();
        boolean playing = true;
        int i = 0;
        int color;
        Serializable[] out;
        while(playing) {

            stuff.print("Enter form x");
            int fx = scan.nextInt();
            scan.nextLine();
            stuff.print("Enter form y");
            int fy = scan.nextInt();
            scan.nextLine();
            stuff.print("Enter to x");
            int tx = scan.nextInt();
            scan.nextLine();
            stuff.print("Enter to y");
            int ty = scan.nextInt();
            scan.nextLine();
            if (i % 2 == 0){
                color = 3;
            } else{
                color = 2;
            }
            out = checkers.movePiece(fx, fy, tx, ty, color);
            if (!(String) out[1].equals("Success"))
            checkers.setBoard((Integer[][]) out[0]);
            //stuff.print((String) out[1]);
            checkers.printBoard();
            i++;

        }
        scan.close();
    }

    /*
    //unnecessary function
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