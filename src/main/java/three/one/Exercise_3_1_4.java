package three.one;

/* Develop Time and Event ADTs that allow processing of data as in the example illustrated on page 367:
min(), get(09:00:13), floor(09:05:00), select(7), keys(09:15:00, 09:25:00),
ceiling(09:30:00), max(), size(09:15:00, 09:25:00),
rank(09:10:25) is 7
09:00:00 Chicago
09:00:03 Phoenix
09:00:13 Houston
09:00:59 Chicago
09:01:10 Houston
09:03:13 Chicago
09:10:11 Seattle
09:10:25 Seattle
09:14:25 Phoenix
09:19:32 Chicago
09:19:46 Chicago
09:21:05 Chicago
09:22:43 Seattle
09:22:54 Seattle
09:25:52 Chicago
09:35:21 Chicago
09:36:14 Seattle
09:37:44 Phoenix
*/

import three.OrderedSequentialSearchST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise_3_1_4 {

    public static void main(String[] args) {
        OrderedSequentialSearchST<String, String> orderedSequentialSearchST = new OrderedSequentialSearchST<>();
        filtDepartureTime(orderedSequentialSearchST);
        //System.out.println(orderedSequentialSearchST);
        System.out.println("min() - > " + orderedSequentialSearchST.min());
        System.out.println("max() - > " + orderedSequentialSearchST.max ());
        System.out.println("get(09:00:13) - > " + orderedSequentialSearchST.get("09:00:13"));
        System.out.println("floor(09:05:00) - > " + orderedSequentialSearchST.floor("09:05:00"));
        System.out.println("floor(09:19:46) - > " + orderedSequentialSearchST.floor("09:19:46"));
        System.out.println("ceiling(09:30:00) - > " + orderedSequentialSearchST.ceiling("09:30:00"));
        System.out.println("select(09:10:25) - > " + orderedSequentialSearchST.select(7));
        System.out.println("keys(09:15:00, 09:25:00) - > " + orderedSequentialSearchST.keys("09:15:00", "09:25:00"));
        System.out.println("size() -> " + orderedSequentialSearchST.size());
    }

    private static void filtDepartureTime( OrderedSequentialSearchST<String, String> orderedSequentialSearchST) {
        orderedSequentialSearchST.put("09:00:00", "Chicago");
        orderedSequentialSearchST.put("09:19:32", "Chicago");
        orderedSequentialSearchST.put("09:01:10", "Houston");
        orderedSequentialSearchST.put("09:00:03", "Phoenix");
        orderedSequentialSearchST.put("09:00:13", "Houston");
        orderedSequentialSearchST.put("09:00:59", "Chicago");
        orderedSequentialSearchST.put("09:03:13", "Chicago");
        orderedSequentialSearchST.put("09:10:11", "Seattle");
        orderedSequentialSearchST.put("09:10:25", "Seattle");
        orderedSequentialSearchST.put("09:14:25", "Phoenix");
        orderedSequentialSearchST.put("09:19:46", "Chicago");
        orderedSequentialSearchST.put("09:21:05", "Chicago");
        orderedSequentialSearchST.put("09:22:43", "Seattle");
        orderedSequentialSearchST.put("09:22:54", "Seattle");
        orderedSequentialSearchST.put("09:25:52", "Chicago");
        orderedSequentialSearchST.put("09:35:21", "Chicago");
        orderedSequentialSearchST.put("09:36:14", "Seattle");
        orderedSequentialSearchST.put("09:37:44", "Phoenix");
    }
}
