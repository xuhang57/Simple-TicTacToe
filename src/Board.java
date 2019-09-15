public class Board {
    private int[][] board;

    public Board(int n) {
        this.board = new int[n][n];
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
