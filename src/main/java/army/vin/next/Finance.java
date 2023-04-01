package army.vin.next;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Finance {

    public static void main(String[] args) {
        String[] vins = VinAndSum.vin.split("\n");
        String[] sum = VinAndSum.sum.split("\n");
        Map<String, String> resultMap = new HashMap<>();
        List<String> registerTableVins = Arrays.asList(RegisterTable.vins.split("\n"))
                .stream()
                .collect(Collectors.toList());
        for (int i = 0; i < vins.length; i++) {
            String[] s = vins[i].split(" ");
            resultMap.put(s[s.length - 1], sum[i]);
        }
        for (int i = 0; i < registerTableVins.size(); i++) {
            String vin = registerTableVins.get(i);
            if(resultMap.containsKey(vin) && !vin.equals("б/н")){
                System.out.println(resultMap.get(vin));
            } else {
                System.out.println("Необлікована");
            }
        }
    }
}
