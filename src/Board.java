public class Board {
    private static final int X = 1;
    private static final int O = -1;
    private static final int EMPTY = 0;

    private int size;
    private int[][] board;

    public Board(int n) {
        this.board = new int[n][n];
        this.size = this.board.length;
    }

    public void display() {
        int numElements = this.size * this.size;
        String[] b = new String[numElements];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int w = i * this.size + j;
                switch (this.board[i][j]) {
                    case X:
                        b[w] = "X";
                        break;
                    case O:
                        b[w] = "O";
                        break;
                    case EMPTY:
                        b[w] = " ";
                        break;
                }
            }
        }
        // display the current board depends on the size of the board
        for (int i = 0; i < this.size; i++) {
            System.out.print("+---");
        }
        System.out.println("+");
        for (int i = 0; i < this.size; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.size-1; j++) {
                int w = i * this.size + j;
                System.out.print(b[w] + " | ");
            }
            System.out.println(b[i * this.size + this.size -1] + " |");
            for (int k = 0; k < this.board.length; k++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
