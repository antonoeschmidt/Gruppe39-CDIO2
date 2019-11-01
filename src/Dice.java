public class Dice {
    private int max;
    private int min;

    public Dice(int min, int max) {
        this.min=min;
        this.max=max;

    }
    public Dice(){
        this.min=1;
        this.max=6;
    }

    public int roll() {
        return this.min + (int)(Math.random() * ((this.max - this.min) + 1));
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}
