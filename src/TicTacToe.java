import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Game t = new Game();
        Scanner scanner = new Scanner(System.in);
        int x = 0, y = 0;
        System.out.println("Welcome to the Tic Tac Toe Game!");
        do {
            System.out.println(t.player == t.X ? "Player X turn": "Player O turn");
            System.out.println("Enter x and y positions");
            x = scanner.nextInt();
            y = scanner.nextInt();
            t.putSign(x, y);
            System.out.println(t.toString());
            System.out.println("--------------------");
            t.displayWinner();
        } while(t.isEmpty);
    }
}
