import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Dice dice1;
    private Dice dice2;
    private boolean vind = false;


    public Game(Player player1, Player player2, Dice dice1, Dice dice2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dice1 = dice1;
        this.dice2 = dice2;

    }

    public void StartGame() {
        while (vind == false) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tryk enter for at slå for " + player1.getName());
            scanner.nextLine();
            playerTurn(player1);
            System.out.println("Tryk enter for at slå for " + player2.getName());
            scanner.nextLine();
            playerTurn(player2);
            System.out.println(player1.getName() + " score: " + player1.getScore());
            System.out.println(player2.getName() + " score: " + player2.getScore());
        }
        if (player1.isWinner() ) {
            System.out.println(player1.getName() + " vinder med " + player1.getScore() + " point.");
        }
        else if (player2.isWinner()){
            System.out.println(player2.getName() + " vinder med " + player2.getScore() + " point.");
        }
        }


    private void playerTurn(Player player) {
        dice1.roll();
        dice2.roll();
        player.setScore(player.getScore() + dice1.getFaceValue());
        System.out.println(player.getName() + " slår med første terning = " + dice1.getFaceValue());
        player.setScore(player.getScore() + dice2.getFaceValue());
        System.out.println(player.getName() + " slår med anden terning = " + dice2.getFaceValue());
        if (dice1.getFaceValue() == 1 && dice2.getFaceValue() == 1) {
            player.setScore(0);
            System.out.println("Ærgerligt, score nulstillet.");
        } else if (dice1.getFaceValue() == dice2.getFaceValue() && player.getScore() < 40) {
            dice1.roll();
            dice1.roll();
            player.setScore(player.getScore() + dice1.getFaceValue() + dice2.getFaceValue());
            System.out.println("Ekstra slag gav " + dice1.getFaceValue() +" og " + dice2.getFaceValue());
        }
        if (player.getScore() >= 40 && dice1.getFaceValue() == dice2.getFaceValue()){
            vind = true;
            player.setWinner(true);
        }
    }

}
