public class Player {
    private Account account;
    private String name;

    public Player(String name) {
        this.name = name;
        this.account = new Account();
    }

    public String getNavn() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return this.account;
    }

}
