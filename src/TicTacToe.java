import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game!");
        System.out.println("Choose your board dimension: e.g. 3");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Board b = new Board(n);
        Game g = new Game(b);
        int x = 0, y = 0;
        do {
            System.out.println(g.player == g.X ? "Player X turn": "Player O turn");
            g.display();
            System.out.println("Enter x and y positions: (e.g. 1 2)");
            x = scanner.nextInt();
            y = scanner.nextInt();
            g.putSign(x, y);
            g.display();
            g.displayWinner();
        } while(g.isEmpty);
    }
}
