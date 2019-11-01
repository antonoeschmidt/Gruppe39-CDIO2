import felter.FieldBase;

import java.util.ArrayList;

public class Board {
    private ArrayList<FieldBase> fields;
    private int minValue = 0;
    private int maxValue = 0;

    public Board(Dice...dices) {
        fields = new ArrayList<FieldBase>();

        // Udregn min og max værdier ud fra summen af min og max for begge dices
        for (Dice dice : dices) {
            this.minValue += dice.getMin();
            //minVaerdi = minVaerdi + terning.getMin();
            this.maxValue += dice.getMax();
            //maxVaerdi = maxVaerdi + terning.getMax();
        }
    }

    public FieldBase getFelt(int number) {
        // Træk min værdien fra tallet, så det passer til nummeret i arrayet.
        // Dvs. at 2 bliver til 0 ved et kast med to terninger med min=1, fordi den mindste mulighed er 2 (1+1)
        int feltArrayIndex = number - this.minValue;

        // Brug modulus til at udregne array index når kastet er større end antallet af felter
        int feltUdregnetArrayIndex = feltArrayIndex % this.fields.size();

        return this.fields.get(feltUdregnetArrayIndex);
    }

    public void addFelt(FieldBase felt) {
        fields.add(felt);
    }

    // terningekast % muligheder
    // 15 % 11 = 4
}
