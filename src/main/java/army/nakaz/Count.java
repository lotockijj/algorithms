package army.nakaz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Count {

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("######");
        for (int i = 1; i < 6; i++) {
            //System.out.println(string.substring(0, string.length() - i));
        }
        for (int i = 1; i < 8; i++) {
            int count = i <= 4 ? i : 8 - i;
            for (int j = 0; j < count; j++) {
               System.out.print("#");
            }
            System.out.print("\n");
        }

        String pattern = "б/н\n" +
                "%s/23\n" +
                "%s/23\n";

        for (int i = 1, j = 264, n = 82; i < 20; i++, j++, n++) {
            //System.out.printf(pattern, j, n);
        }
        String pattern2 = "04.03.2023\n" +
                "17.03.2023\n" +
                "15.03.2023";
        for (int i = 75; i < 83; i++) {
            //System.out.println(i);
        }
        String[] splitString = str.split("\n");
        for (int i = 0; i < splitString.length; i++) {
            System.out.println(splitString[i].replace("+38", ""));
        }
    }

    private static final String str = "+380989968618\n" +
            "+380963441544\n" +
            "+380969394201\n" +
            "+380958022356\n" +
            "+380983257470\n" +
            "+380679559433\n" +
            "+380975895589\n" +
            "+380980807559\n" +
            "+380984623293\n" +
            "+380962424083\n" +
            "+380974318796\n" +
            "+380964722945\n" +
            "+380975012293\n" +
            "+380632550128\n";
}

















