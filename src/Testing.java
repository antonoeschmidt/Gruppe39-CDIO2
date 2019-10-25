public class Testing {
    private static Dice terning;

    public static void main(String[] args) {
        terning = new Dice(0);
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        int i = 0;
        while (i < 1000) {
            int value = terning.roll() + terning.roll();
            if (value == 2){
                v2++;
            } else if (value == 3){
                v3++;
            } else if (value == 4){
                v4++;
            } else if (value == 5){
                v5++;
            } else if (value == 6){
                v6++;
            } else if (value == 7){
                v7++;
            } else if (value == 8){
                v8++;
            } else if (value == 9){
                v9++;
            } else if (value == 10){
                v10++;
            } else if (value == 11){
                v11++;
            } else if (value == 12){
                v12++;
            }
                i++;
        }
        System.out.println("2 = " + v2);
        System.out.println("3 = " + v3);
        System.out.println("4 = " + v4);
        System.out.println("5 = " + v5);
        System.out.println("6 = " + v6);
        System.out.println("7 = " + v7);
        System.out.println("8 = " + v8);
        System.out.println("9 = " + v9);
        System.out.println("10 = " + v10);
        System.out.println("11 = " + v11);
        System.out.println("12 = " + v12);

    }
}
