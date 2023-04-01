package golden.key;

/* Make the least amount of shots in order to reach 100 score with 16, 17, 23, 24, 39, 40*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Kee_4_5_8 {

    public static void main(String[] args) {
        List<Integer> shots = getShots(16, 17, 23, 24, 39, 40);
        Collections.sort(shots);
        shots.forEach(e -> System.out.print(e + ", "));
    }

    private static List<Integer> getShots(int ... a) {
        List<Integer> shots = new ArrayList<>();
        int border = 0;
        boolean found = true;
        while (found){
            found = tryToFindShots(a, shots);
            border++;
            if(border > 1000) break;
        }
        return shots;
    }

    private static boolean tryToFindShots(int[] arr, List<Integer> shots) {
        int sum = shots.stream().reduce(0, (a, b) -> a + b);
        Random random = new Random();
        while(sum <= 100){
            int temp = getRandomNumberFromList(arr, random);
            shots.add(temp);
            sum = shots.stream().reduce(0, (a, b) -> a + b);
            if(sum == 100){
                break;
            }
        }
        if(sum == 100){
            return false;
        } else {
            shots.clear();
        }
        return true;
    }

    private static int getRandomNumberFromList(int[] arr, Random random) {
        return arr[random.nextInt(arr.length - 1)];
    }
}
