package Files;

public class Main {
    public static void main(String[] args){
        Integer [][] board = init();
        Files.Checkers checkers = new Files.Checkers();
        checkers.printBoard(board);
    }

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
}
