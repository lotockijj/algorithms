package three.five;

/*
Registrar scheduling. The registrar at a prominent northeastern University recently scheduled
an instructor to teach two different classes at the same exact time. Help the registrar prevent
future mistakes by describing a method to check for such conflicts. For simplicity, assume all
classes run for 50 minutes starting at 9:00, 10:00, 11:00, 1:00, 2:00, or 3:00.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_3_5_25 {
    private final static String HOURS_AS_STRING = "9:00, 10:00, 11:00, 1:00, 2:00, 3:00";
    public static void main(String[] args) {
        BinarySearchSET<String> binarySearchSET = new BinarySearchSET<>(100);
        List<String> hours = Arrays.stream(HOURS_AS_STRING.split(",")).map(String::trim).collect(Collectors.toList());
        for (int i = 0; i < hours.size(); i++) {
            binarySearchSET.put(hours.get(i));
        }
        if(binarySearchSET.contains("9:00")){
            System.out.println("Conflicts");
        } else {
            System.out.println("Free");
        }
    }
}
