package golden.key;

import java.util.Random;

public class Part_two_2 {

    public static void main(String[] args) {
        Random random = new Random();
        tryOneHundred(random);
    }

    private static void tryOneHundred(Random random) {
        int firstWin = 0;
        int secondWin = 0;
        for (int i = 0; i < 500; i++) {
            int firstFriend = random.nextInt(4) + 1;
            int secondFriend = random.nextInt(4) + 1;
            if((firstFriend + secondFriend)%2 == 0){
                firstWin++;
            } else {
                secondWin++;
            }
        }
        System.out.println("First win: " + firstWin + ", Second win: " + secondWin);
    }
}
