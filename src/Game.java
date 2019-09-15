public class Game {
    private static final int X = 1;
    private static final int O = -1;
    private static final int EMPTY = 0;

    private int player;
    private int[][] board;
    private int size;
    private boolean isEmpty = true;

    // assuming the first player is player X
    public Game(Board board) {
        int[][] b = board.getBoard();
        this.board = b;
        this.size = this.board.length;
        this.player = X;
    }

    // depends on user's input to select a player
    public Game(Board board, Player p) {
        int[][] b = board.getBoard();
        this.board = b;
        this.size = this.board.length;
        int playerName = p.getName();
        if (playerName == 1) {
            this.player = X;
        } else {
            this.player = O;
        }
    }

    public void putSign(int x, int y) {
        if (x < 0 || x >= this.size || y < 0 || y >= this.size) {
            System.out.println("Invalid Board Position");
            return;
        }

        if (this.board[x][y] != EMPTY) {
            System.out.println("Board Position Occupied");
            return;
        }

        this.board[x][y] = this.player; // place the mark for the current player
        this.player = -this.player; // switch player
    }

    public boolean isWin(int player) {
        // 3 different winning rules in general
        return (this.checkDiagonal(player) || this.checkHorizontal(player) || this.checkVertical(player));
    }

    public boolean checkDiagonal(int player) {
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            sum += this.board[i][i];
        }
        int back = 0;
        for (int i = this.size - 1; i >= 0; i--) {
            back += this.board[i][i];
        }
        return (sum == player * this.size) || (back == player * this.size);
    }

    public boolean checkHorizontal(int player) {
        for (int row = 0; row < this.size; row++) {
            int sum = 0;
            for (int col = 0; col < this.size; col++) {
                sum += this.board[row][col];
            }
            if (sum == (player * this.size)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkVertical(int player) {
        for (int col = 0; col < this.size; col++) {
            int sum = 0;
            for (int row = 0; row < this.size; row++) {
                sum += this.board[row][col];
            }
            if (sum == (player * this.size)) {
                return true;
            }
        }
        return false;
    }

    public void displayWinner() {
        if (isWin(X)) {
            System.out.println("X wins!");
            this.isEmpty = false;
        } else if (isWin(O)) {
            System.out.println("O wins!");
            this.isEmpty = false;
        } else {
            if (!this.isEmpty) {
                System.out.println("Draw!");
            }
        }
    }

    public int getPlayer() {
        return this.player;
    }

    public int getXTick() {
        return X;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }
}
