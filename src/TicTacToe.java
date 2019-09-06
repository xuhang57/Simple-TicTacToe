import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Board b = new Board(3);
        Game g = new Game(b);
        Scanner scanner = new Scanner(System.in);
        int x = 0, y = 0;
        System.out.println("Welcome to the Tic Tac Toe Game!");
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
