public class Spiller {
    private Konto konto;
    private String name;

    public Spiller(String name) {
        this.name = name;
        this.konto = new Konto();
    }

    public String getNavn() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Konto getKonto() {
        return this.konto;
    }

}
