public class ReversiKataApi {

    private final static int boardSize = 8;

    public static void main(String... args) {
        int[][] board = new int[boardSize][boardSize];
        board[3][3] = 1;
        board[4][4] = 1;
        board[3][4] = -1;
        board[4][3] = -1;

        ReversiKata rk = new ReversiKata(board);
        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (var i = 0; i < boardSize; i++) {
            for(var j = 0; j < boardSize; j++){
             System.out.print(" " + fieldValue(board[i][j]));
            }
            System.out.println("");
        }
    }

    private static String fieldValue(int field) {
        switch (field) {
            case 1:
                return "B";
            case 0:
                return ".";
            case -1:
                return "R";
            default:
                throw new IllegalArgumentException();
        }
    }
}
