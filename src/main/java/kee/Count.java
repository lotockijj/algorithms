package kee;

import java.util.HashSet;
import java.util.Set;

public class Count {

    public static void main(String[] args) {
        int lowerBound = 300;
        int upperBound = 350;
        int tenth = 10;
        int duzin = 12;
        Set<Integer> result = new HashSet<>();
        for (int i = lowerBound; i < upperBound; i++) {
            for (int j = 18; j < 40; j++) {
                for (int k = 10; k < 40; k++) {
                    if(i + 2 == j*tenth && i + 8 == k*duzin && j*tenth > lowerBound && j*tenth < upperBound){
                        result.add(i);
                    }
                }
            }
        }
        result.forEach(System.out::println); //328
    }
}
