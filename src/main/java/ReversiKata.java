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
        NewPawn newPawn = findNewPawn(newBoard);
        return checkForPresenceOfPawnInNeighborhood(newBoard, newPawn) != 0;
    }

    public int[][] getBoard() {
        return board;
    }

    private int checkForPresenceOfPawnInNeighborhood(int[][] newBoard, NewPawn newPawn) {
        var numberPawsInNeighborhood = 0;
        var boardSize = board[0].length;

        for (var i = -1; i <= 1; i++) {
            for (var j = -1; j <= 1; j++) {
                if (isFieldOnBoard(newPawn.getX(), newPawn.getY(), i, j, boardSize)) {
                    if (newAndOldPawnsHaveDifferentColours(newBoard[newPawn.getX() + i][newPawn.getY() + j],
                        newPawn.getValue())) {
                        numberPawsInNeighborhood++;
                    }
                }
            }
        }
        return numberPawsInNeighborhood;
    }

    private boolean newAndOldPawnsHaveDifferentColours(int existingPawn, int newPawn) {
        return (Math.abs(existingPawn + newPawn) == 1);
    }

    private boolean isFieldOnBoard(int centralFieldX, int centralFieldY, int offsetX, int offsetY,
        int boardSize) {
        return ((centralFieldX + offsetX >= 0
            && centralFieldY + offsetY >= 0
            && centralFieldX + offsetX < boardSize
            && centralFieldY + offsetY < boardSize)
            && (offsetX != 0 || offsetY != 0)
        );
    }

    private NewPawn findNewPawn(int[][] board) {
        NewPawn newPawn = null;
        var boardSize = board[0].length;

        for (var i = 0; i < boardSize; i++) {
            for (var j = 0; j < boardSize; j++) {
                if (Math.abs(board[i][j]) > 1) {
                    newPawn = new NewPawn(i, j, board[i][j]);
                    break;
                }
            }
            if (null != newPawn) {
                break;
            }
        }
        return newPawn;
    }

    private class NewPawn {
        private int x;
        private int y;
        private int value;

        public NewPawn(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return value;
        }
    }
}
