package golden.key;

import java.util.Random;

/* Two pupils throw coins. If coins sides are the same, wins first pupil, if different - second. Who does win more ? */

public class Kee_4_5_10 {
    public static void main(String[] args) {
        Random random = new Random();
        int chancesEquals = 0;
        int chancesDiffer = 0;
        for (int i = 0; i < 1000; i++) {
            if(random.nextBoolean() == random.nextBoolean()){
                chancesEquals++;
            } else {
                chancesDiffer++;
            }
        }
        double result = 1.0 * chancesEquals/chancesDiffer;
        System.out.println(result);
    }
}
