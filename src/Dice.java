public class Dice {
    private int max;
    private int min;

    public Dice(int max,int min) {
        this.max=max;
        this.min=min;

    }
    public Dice(){
        this.max=6;
        this.min=1;
    }

    public int roll() {
        return this.min + (int)(Math.random() * ((this.max - this.min) + 1));
    }
}
