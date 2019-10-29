import felter.FeltBase;

import java.util.ArrayList;

public class SpilleBraet {
    private ArrayList<FeltBase> felter;
    private int minVaerdi = 0;
    private int maxVaerdi = 0;

    public SpilleBraet(Terning ...terninger) {
        felter = new ArrayList<FeltBase>();

        // Udregn min og max værdier ud fra summen af min og max for begge terninger
        for (Terning terning : terninger) {
            this.minVaerdi += terning.getMin();
            //minVaerdi = minVaerdi + terning.getMin();
            this.maxVaerdi += terning.getMax();
            //maxVaerdi = maxVaerdi + terning.getMax();
        }
    }

    public FeltBase getFelt(int nummer) {
        // Træk min værdien fra tallet, så det passer til nummeret i arrayet.
        // Dvs. at 2 bliver til 0 ved et kast med to terninger med min=1, fordi den mindste mulighed er 2 (1+1)
        int feltArrayIndex = nummer - this.minVaerdi;

        // Brug modulus til at udregne array index når kastet er større end antallet af felter
        int feltUdregnetArrayIndex = feltArrayIndex % this.felter.size();

        return this.felter.get(feltUdregnetArrayIndex);
    }

    public void addFelt(FeltBase felt) {
        felter.add(felt);
    }

    // terningekast % muligheder
    // 15 % 11 = 4
}
