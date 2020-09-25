package spil;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Dice.roll();
            System.out.println("Roll:" + (i+1) + "  " + Dice.roll());
        }


    }
}
