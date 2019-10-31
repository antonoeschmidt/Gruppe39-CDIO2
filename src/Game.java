import felter.ColdDesert;
import felter.FeltBase;
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

    private void pauseNaesteRunde(boolean ekstraTur){
        if (ekstraTur){
            System.out.print("Tryk ENTER for at spille ekstratur...");
        } else {
            System.out.print("Tryk ENTER for næste runde...");
        }
        in.nextLine();
    }

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
        braet.addFelt(new WalledCity());
        braet.addFelt(new Crater());
        braet.addFelt(new ThePit());
        braet.addFelt(new TheWereWall());
        braet.addFelt(new HutsInTheMountain());
        braet.addFelt(new Goldmine());
        braet.addFelt(new BlackCave());

        String name1, name2;
        int win_score = 3000;

        System.out.print("Indtast navn på spiller 1: ");
        name1 = this.in.nextLine();
        System.out.print("indtast navn på spiller 2: ");
        name2 = this.in.nextLine();

        System.out.println();

        System.out.println("player1: " + name1 + ", " + "player2: " + name2);

        Spiller spiller1 = new Spiller(name1);
        Spiller spiller2 = new Spiller(name2);

        Spiller[] spillere = {spiller1, spiller2};

        System.out.println();

        this.pauseNaesteRunde(false);

        boolean spilErSlut = false;

        while (!spilErSlut) {
            Spiller spillerHoejsteScore = null;

            for (Spiller spiller : spillere) {
                System.out.println();

                Konto spillerKonto = spiller.getKonto();

                // Vis nuværende score for begge spillere inden der rulles med terningerne
                System.out.println(spiller.getNavn() + " balance: " + spillerKonto.getBalance());

                this.spilRunde(braet, terning1, terning2, spillerKonto);

                if (spillerHoejsteScore == null) {
                    spillerHoejsteScore = spiller;
                } else {
                    if (spillerKonto.getBalance() > spillerHoejsteScore.getKonto().getBalance()) {
                        spillerHoejsteScore = spiller;
                    }
                }


            }

            if (spillerHoejsteScore.getKonto().getBalance() >= win_score) {
                spilErSlut = true;

                System.out.println();

                System.out.println(spillerHoejsteScore.getNavn() + " har vundet med " + spillerHoejsteScore.getKonto().getBalance() + " points!");
            }
        }
    }
    private void spilRunde(SpilleBraet braet, Terning terning1, Terning terning2, Konto spillerKonto) {
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

        System.out.println("Ny score: " + spillerKonto.getBalance());

        // Pause med forskellig besked alt efter om det er en ekstra tur
        boolean rundeErEkstraTur = felt.getEkstraTur();
        this.pauseNaesteRunde(rundeErEkstraTur);

        if (felt.getEkstraTur()) {
            System.out.println();
            this.spilRunde(braet, terning1, terning2, spillerKonto);
        }
    }

}
