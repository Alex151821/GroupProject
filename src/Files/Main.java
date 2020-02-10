package Files;

import java.io.Serializable;
import java.util.Scanner;

public class Main {
    static Files.Checkers checkers = new Files.Checkers();
    static Files.Stuff stuff = new Files.Stuff();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        checkers.printBoard();
        boolean playing = true;
        int i = 0;
        int color;
        Serializable[] out;
        String thing;
        int fx;
        int fy;
        int tx = 0;
        int ty = 0;
        while (playing) {
            do {
                //Enter coordinate of piece to move
                stuff.print("Enter from x");
                fx = scan.nextInt();
                scan.nextLine();
                stuff.print("Enter from y");
                fy = scan.nextInt();
                scan.nextLine();
                //choose movement direction
                stuff.print("Forward or backward? f/b");
                String fb = scan.nextLine();
                if (fb.toLowerCase().equals("f")) {
                    ty = fy - 1;
                } else if (fb.toLowerCase().equals("b")) {
                    ty = fy + 1;
                }
                stuff.print("Right or Left r/l");
                String lr = scan.nextLine();
                if (lr.toLowerCase().equals("l")) {
                    tx = fx - 1;
                    stuff.print("hello");
                } else if (lr.toLowerCase().equals("r")) {
                    tx = fx + 1;
                    stuff.print("hi");
                }
                if (i % 2 == 0) color = 3;
                else color = 2;

                stuff.print(fx + " " + fy + " " + tx + " " + ty);
                //piece movement
                out = checkers.movePiece(fx, fy, tx, ty, color);
                thing = (String) out[1];
                checkers.setBoard((Integer[][]) out[0]);
                if (!thing.equals("Success")) {
                    stuff.print((String) out[1]);
                }
                //stuff.print((String) out[1]);
            } while (!thing.equals("Success"));
            checkers.printBoard();
            i++;
            switch (winCheck(checkers.getBoard())) {
                case 0:
                    stuff.print("Black Wins!!!");
                    break;
                case 1:
                    stuff.print("White Wins!!!");
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }

    public static int winCheck(Integer[][] board) {
        int[] count = {0, 0};
        for (Integer[] i : board) {
            for (Integer j : i) {
                switch (j) {
                    case 3:
                    case 5:
                        count[0]++;
                        break;
                    case 2:
                    case 4:
                        count[1]++;
                        break;
                    default:
                        break;

                }
            }
        }//end for loop
        if (count[1] == 0) {
            return 0;
        } else if (count[0] == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}