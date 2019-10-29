public class Konto {
    private int balance = 1000;

    public void withdraw(int amount) {
        balance -= amount;
        //balance = balance - amount;
    }
    public void deposit(int amount) {
        balance += amount;
        //balance = balance + amount;
    }

    public int getBalance() {
        return this.balance;
    }

}
