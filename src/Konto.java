public class Konto {
    private int money;

    public Konto() {
        this.money = money;
    }

    public void depositMoney(int deposit) {
        money =+ deposit;
    }

    public void withdrawMoney(int withdrawal) {
        money =- withdrawal;
    }

    public int getMoney() {
        return money;
    }
}
