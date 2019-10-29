import felter.ColdDesert;
import felter.FeltBase;
import felter.PalaceGates;
import felter.Tower;
import felter.Monastery;

import java.util.Scanner;

public class Game {
    public void startSpil() {
        int terning1Min = 1;
        int terning1Max = 6;
        Terning terning1 = new Terning(terning1Min, terning1Max);

        int terning2Min = 1;
        int terning2Max = 6;
        Terning terning2 = new Terning(terning2Min, terning2Max);

        SpilleBraet braet = new SpilleBraet(terning1, terning2);

        braet.addFelt(new PalaceGates());
        braet.addFelt(new Tower());
        braet.addFelt(new ColdDesert());
        braet.addFelt(new Monastery());

        String name1, name2;
        int win_score = 3000;

        Scanner in = new Scanner(System.in);
        System.out.print("Indtast navn på spiller 1: ");
        name1 = in.nextLine();
        System.out.print("indtast navn på spiller 2: ");
        name2 = in.nextLine();
        System.out.println("player1: " + name1 + ", " + "player2: " + name2);

        Spiller spiller1 = new Spiller(name1);
        Spiller spiller2 = new Spiller(name2);

        Spiller[] spillere = {spiller1, spiller2};


        boolean spilErSlut = false;

        while (!spilErSlut) {
            Spiller spillerHoejsteScore = null;

            for (Spiller spiller : spillere) {
                System.out.println();

                Konto spillerKonto = spiller.getKonto();

                // Vis nuværende score for begge spillere inden der rulles med terningerne
                System.out.println(spiller.getNavn() + " balance: " + spillerKonto.getBalance());

                int number1 = terning1.roll();
                int number2 = terning2.roll();

                int sum = number1 + number2;
                System.out.println("resultat: " + number1 + " + " + number2 + " = " + sum);

                FeltBase felt = braet.getFelt(sum);

                int feltVaerdi = felt.getVaerdi();

                System.out.println(felt.getNavn());
                System.out.println(felt.getBesked());

                if (feltVaerdi > 0) {
                    spillerKonto.deposit(feltVaerdi);
                } else {
                    // Brug den absolutte værdi (realværdien), så f.eks. -300 eller 300 bliver til 300
                    spillerKonto.withdraw(Math.abs(feltVaerdi));
                }

                System.out.println(spiller.getNavn() + " ny score: " + spillerKonto.getBalance());

                if (spillerHoejsteScore == null) {
                    spillerHoejsteScore = spiller;
                } else {
                    if (spillerKonto.getBalance() > spillerHoejsteScore.getKonto().getBalance()) {
                        spillerHoejsteScore = spiller;
                    }
                }

                System.out.print("Tryk ENTER for næste runde...");
                in.nextLine();
            }

            if (spillerHoejsteScore.getKonto().getBalance() >= win_score) {
                spilErSlut = true;

                System.out.println(spillerHoejsteScore.getNavn() + " har vundet med " + spillerHoejsteScore.getKonto().getBalance() + " points!");
            }
        }
    }

}
