package felter;

public class TheWereWall extends FeltBase {
    public TheWereWall() {
        super.feltVaerdi = -80;
        super.feltNavn = "The WereWall";
        super.feltBesked = "du betaler 80 mønter for at komme igennem porten og spare tid (Du for et ekstra slag)";
        super.ekstraTur = true;
    }
}
