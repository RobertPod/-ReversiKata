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
        int[] newPawn = findNewPawn(newBoard);
        return checkForPresenceOfPawnInNeighborhood(newBoard, newPawn) != 0;
    }

    private int checkForPresenceOfPawnInNeighborhood(int[][] newBoard, int[] newPawn) {
        var numberPawsInNeighborhood = 0;
        var boardSize = board[0].length;
        for (var i = -1; i <= 1; i++) {
            for (var j = -1; j <= 1; j++) {
                if (newPawn[0] + i >= 0
                    && newPawn[1] + j >= 0
                    && newPawn[0] + i < boardSize
                    && newPawn[1] + j < boardSize
                    && (i != 0 && j != 0)
                ) {
                    if (newBoard[newPawn[0] + i][newPawn[1] + j] != 0) {
                        numberPawsInNeighborhood++;
                    }
                }
            }
        }
        return numberPawsInNeighborhood;
    }

    private int[] findNewPawn(int[][] board) {
        int[] retXYColor = new int[3];
        var boardSize = board[0].length;
        for (var i = 0; i < boardSize; i++) {
            for (var j = 0; j < boardSize; j++) {
                if (Math.abs(board[i][j]) > 1) {
                    retXYColor[0] = i;
                    retXYColor[1] = j;
                    retXYColor[2] = board[i][j];
                    break;
                }
            }
            if (retXYColor[2] != 0) {
                break;
            }
        }
        return retXYColor;
    }

    public int[][] getBoard() {
        return board;
    }
}
