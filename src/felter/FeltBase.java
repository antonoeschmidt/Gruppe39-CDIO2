package felter;

public class FeltBase {
    String feltNavn;
    int feltVaerdi;
    String feltBesked;
    boolean ekstraTur = false;

    public boolean getEkstraTur() {
        return this.ekstraTur;
    }

    public int getVaerdi() {
        return this.feltVaerdi;
    }

    public String getNavn() {
        return this.feltNavn;
    }

    public String getBesked() {
        return this.feltBesked;
    }

}
