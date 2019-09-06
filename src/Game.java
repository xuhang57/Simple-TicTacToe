public class Game {
    public static final int X = 1;
    public static final int O = -1;
    public static final int empty = 0;

    public int player = X;
    public int[][] board;
    public boolean isEmpty = true;

    public Game(Board board) {
        this.board = board.board;
    }

    public void putSign(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Invalid Board Position");
            return;
        }

        if (this.board[x][y] != empty) {
            System.out.println("Board Position Occupied");
            return;
        }

        this.board[x][y] = player; // place the mark for the current player
        player = -player; // switch player
    }

    public boolean isWin(int player) {
        return ((this.board[0][0] + this.board[0][1] + this.board[0][2] == player * 3) ||
                (this.board[1][0] + this.board[1][1] + this.board[1][2] == player * 3) ||
                (this.board[2][0] + this.board[2][1] + this.board[2][2] == player * 3) ||
                (this.board[0][0] + this.board[1][0] + this.board[2][0] == player * 3) ||
                (this.board[0][1] + this.board[1][1] + this.board[2][1] == player * 3) ||
                (this.board[0][2] + this.board[1][2] + this.board[2][2] == player * 3) ||
                (this.board[0][0] + this.board[1][1] + this.board[2][2] == player * 3) ||
                (this.board[2][0] + this.board[1][1] + this.board[0][2] == player * 3));
    }

    public void displayWinner() {
        if (isWin(X)) {
            System.out.println("X wins!");
            isEmpty = false;
        } else if (isWin(O)) {
            System.out.println("O wins!");
            isEmpty = false;
        } else {
            if (!isEmpty) {
                System.out.println("Draw!");
            }
        }
    }

    public void display() {
        String[] b = new String[9];
        isEmpty = false;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                int w = i * this.board.length + j;
                switch (this.board[i][j]) {
                    case X:
                        b[w] = "X";
                        break;
                    case O:
                        b[w] = "O";
                        break;
                    case empty:
                        b[w] = " ";
                        isEmpty = true;
                        break;
                }
            }
        }

        System.out.println("+---+---+---+");
        System.out.println("| " + b[0] + " | " + b[1] + " | " + b[2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + b[3] + " | " + b[4] + " | " + b[5] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + b[6] + " | " + b[7] + " | " + b[8] + " |");
        System.out.println("+---+---+---+");
    }
}
