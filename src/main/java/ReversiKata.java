/*
 * Convention:
 * 0 - empty field
 * 1 - black
 * 2 - new black move - proposition
 * -1 - red
 * -2 - new red move - proposition
 */
public class ReversiKata {

    private static int[][] board;

    public ReversiKata(int[][] board) {
        this.board = board;
    }

    /*
     * If the proposed move is correct, returns true
     */
    public boolean checkForCorrectMove(int[][] newBoard) {
        return true;
    }

    public int[][] getBoard() {
        return board;
    }
}
