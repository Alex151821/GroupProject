package Files;

public class Main {
    public static void main(String[] args){
        int [][] board = init();
    }

    public static int[][] init(){
         int [][] board = new int[8][8];
        int [] board0 = {0, 1, 0, 1, 0, 1, 0, 1};
        int [] board1 = {1, 0, 1, 0, 1, 0, 1, 0};
        for (int i = 0; i < board.length; i++){
            if (i % 2 == 0){
                board[i] = board0;
            } else{
                board[i] = board1;
            }
        }
        return board;
    }
}
