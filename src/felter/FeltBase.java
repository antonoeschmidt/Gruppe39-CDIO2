package felter;

public class FeltBase {
    private String feltNavn;
    private int feltVaerdi;
    private String feltBesked;
    private boolean ekstraTur = false;

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
