import felter.FeltBase;
import felter.PalaceGates;
import felter.Tower;

public class SpilleBraet {
    private FeltBase[] felter;

    public SpilleBraet() {
        felter = new FeltBase[13];

        felter[0] = null;   // Bliver ikke brugt, to terninger kan mindst give 2
        felter[1] = null;   // Bliver ikke brugt, to terninger kan mindst give 2

        felter[2] = new PalaceGates();
        felter[3] = new Tower();
    }

    public FeltBase getFelt(int nummer) {
        return this.felter[nummer];
    }
}
