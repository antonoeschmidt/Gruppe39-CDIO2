import org.junit.Test;

import static org.junit.Assert.*;

public class KontoTest {

    @Test
    public void withdrawTest() {
        //Konto starter på 1000
        Konto konto = new Konto();
        konto.withdraw(2000);
        //Kontoen får i første omgang værdien -1000, men skal rette dette til 0, da man ikke kan have en negativ konto
        assertEquals(0,konto.getBalance());
    }

    @Test
    public void depositTest() {
        //Konto starter på 1000
        Konto konto = new Konto();
        konto.deposit(500);
        //Kontoen får tilført 500, og skal derefter have 1500 efter deposit
        assertEquals(1500,konto.getBalance());

    }
}