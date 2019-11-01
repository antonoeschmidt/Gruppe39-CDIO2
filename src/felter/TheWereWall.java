package felter;

public class TheWereWall extends FieldBase {
    public TheWereWall() {
        super.fieldValue = -80;
        super.fieldName = "The WereWall";
        super.fieldMessage = "du betaler 80 mønter for at komme igennem porten og spare tid (Du for et ekstra slag)";
        super.extraTurn = true;
    }
}
