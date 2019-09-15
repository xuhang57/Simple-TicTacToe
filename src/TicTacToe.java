import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game!");
        System.out.println("Choose your board dimension: e.g. 3");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Player 1 or Player 2 (1 means player X and 2 means player O): e.g. 1");
        int player = scanner.nextInt();
        Player p = new Player(player);
        Board b = new Board(n);
        Game g = new Game(b, p);
        // x is the row and y is the col on the board.
        int x = 0, y = 0;
        // display the empty board
        b.display();
        do {
            System.out.println(g.getPlayer() == g.getXTick() ? "Player X turn": "Player O turn");
            System.out.println("Enter x and y positions: (e.g. 1 2)");
            x = scanner.nextInt();
            y = scanner.nextInt();
            g.putSign(x, y);
            b.display();
            // check winner or continue
            g.displayWinner();
        } while(g.isEmpty()); // as long as the board is not full or neither player has won, keep running
    }
}
