import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void simpleRoll() {
        Dice dice = new Dice(0);
        for (int i = 0; i < 1000000; i++) {
            assertEquals(3.5,dice.roll(),2.5);
        }

    }

    @Test
    public void frequencyRoll() {
        Dice dice = new Dice(0);

    }
}