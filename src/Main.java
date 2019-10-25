import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indtast dit navn Player1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Indtast dit navn Player2: ");
        String player2Name = scanner.nextLine();
        Player player1 = new Player(player1Name, 0, false);
        Player player2 = new Player(player2Name, 0, false);
        Dice dice1 = new Dice(0);
        Dice dice2 = new Dice(0);
        Game game = new Game(player1,player2,dice1,dice2);
        game.StartGame();
    }
}
