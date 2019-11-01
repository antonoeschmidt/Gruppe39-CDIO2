package felter;

public class FieldBase {
    String fieldName;
    int fieldValue;
    String fieldMessage;
    boolean extraTurn = false;

    public int getValue() {
        return this.fieldValue;
    }

    public String getName() {
        return this.fieldName;
    }

    public String getMessage() {
        return this.fieldMessage;
    }

    public boolean getExtraTurn() {
        return extraTurn;
    }
}
