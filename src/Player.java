public class Player {
    private String name;
    private int score;
    private boolean winner;

    public Player(String name, int score, boolean winner) {
        this.name = name;
        this.score = score;
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
