import felter.ColdDesert;
import felter.FieldBase;
import felter.PalaceGates;
import felter.Tower;
import felter.Monastery;
import felter.WalledCity;
import felter.Crater;
import felter.TheWereWall;
import felter.ThePit;
import felter.BlackCave;
import felter.Goldmine;
import felter.HutsInTheMountain;


import java.util.Scanner;

public class Game {
    private Scanner in;

    public Game(){
        this.in = new Scanner(System.in);
    }

    private void pauseNextRound(boolean extraTurn){
        if (extraTurn){
            System.out.print("Tryk ENTER for at spille ekstratur...");
        } else {
            System.out.print("Tryk ENTER for næste runde...");
        }
        in.nextLine();
    }

    public void startGame() {
        int dice1Min = 1;
        int dice1Max = 6;
        Dice dice1 = new Dice(dice1Min, dice1Max);

        int dice2Min = 1;
        int dice2Max = 6;
        Dice dice2 = new Dice(dice2Min, dice2Max);

        Board board = new Board(dice1, dice2);

        board.addFelt(new PalaceGates());
        board.addFelt(new Tower());
        board.addFelt(new ColdDesert());
        board.addFelt(new Monastery());
        board.addFelt(new WalledCity());
        board.addFelt(new Crater());
        board.addFelt(new ThePit());
        board.addFelt(new TheWereWall());
        board.addFelt(new HutsInTheMountain());
        board.addFelt(new Goldmine());
        board.addFelt(new BlackCave());

        String name1, name2;
        int win_score = 3000;

        System.out.print("Indtast navn på spiller 1: ");
        name1 = this.in.nextLine();
        System.out.print("indtast navn på spiller 2: ");
        name2 = this.in.nextLine();

        System.out.println();

        System.out.println("player1: " + name1 + ", " + "player2: " + name2);

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        Player[] players = {player1, player2};

        System.out.println();

        this.pauseNextRound(false);

        boolean gameEnded = false;

        while (!gameEnded) {
            Player playerTopScore = null;

            for (Player player : players) {
                System.out.println();

                Account spillerAccount = player.getAccount();

                // Vis nuværende score for begge players inden der rulles med terningerne
                System.out.println(player.getNavn() + " balance: " + spillerAccount.getBalance());

                this.playRound(board, dice1, dice2, spillerAccount);

                if (playerTopScore == null) {
                    playerTopScore = player;
                } else {
                    if (spillerAccount.getBalance() > playerTopScore.getAccount().getBalance()) {
                        playerTopScore = player;
                    }
                }


            }

            if (playerTopScore.getAccount().getBalance() >= win_score) {
                gameEnded = true;

                System.out.println();

                System.out.println(playerTopScore.getNavn() + " har vundet med " + playerTopScore.getAccount().getBalance() + " points!");
            }
        }
    }
    private void playRound(Board board, Dice dice1, Dice dice2, Account playerAccount) {
        int number1 = dice1.roll();
        int number2 = dice2.roll();

        int sum = number1 + number2;
        System.out.println("resultat: " + number1 + " + " + number2 + " = " + sum);

        FieldBase field = board.getFelt(sum);

        int fieldValue = field.getValue();

        System.out.println(field.getName());
        System.out.println(field.getMessage());

        if (fieldValue > 0) {
            playerAccount.deposit(fieldValue);
        } else {
            // Brug den absolutte værdi (realværdien), så f.eks. -300 eller 300 bliver til 300
            playerAccount.withdraw(Math.abs(fieldValue));
        }

        System.out.println("Ny score: " + playerAccount.getBalance());

        // Pause med forskellig besked alt efter om det er en ekstra tur
        boolean rundeErEkstraTur = field.getExtraTurn();
        this.pauseNextRound(rundeErEkstraTur);

        if (field.getExtraTurn()) {
            System.out.println();
            this.playRound(board, dice1, dice2, playerAccount);

        }
    }

}
