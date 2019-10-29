public class Terning {
    private int max;
    private int min;

    public Terning(int min, int max) {
        this.min=min;
        this.max=max;

    }
    public Terning(){
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
