package army;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AktCreator {

    public static String namesOfCars = "Камаз-5320 вантажн.спец. Самоскид\n" +
            "RENAULT DUSTER універсал-В\n" +
            "ГАЗ-66 спеціал. Вантажний фургон";

    public static String militaryNumbers = "ХТС532000N1023872\n" +
            "VF1HJD40664630378\n" +
            "ХТН006615Н0516084";

    public static String numbersOfCars = "2021И7\n" +
            "2022И7\n" +
            "2023И7";

    public static void main(String[] args) throws IOException {

        String[] names = namesOfCars.split("\n");
        String[] numbers = militaryNumbers.split("\n");
        String[] labels = numbersOfCars.split("\n");
        for (int i = 0; i < names.length; i++) {
            List<String> newLines = new ArrayList<>();
            for (String line : Files.readAllLines(Paths.get("source2.html"), StandardCharsets.UTF_8)) {
                if (line.contains("nameOfCar")) {
                    line = line.replace("nameOfCar", names[i]);
                }
                if (line.contains("vehicleNumber")) {
                    line = line.replace("vehicleNumber", numbers[i]);
                }
                if (line.contains("militaryNumber")) {
                    line = line.replace("militaryNumber", labels[i]);
                }
                String vehicleNumber1 = ""; //  VehicleTTT     NumberTTT
                String vehicleNumber2 = ""; //  VehicleTTT     NumberTTT
                if(numbers[i].length() > 8){
                    vehicleNumber1 = numbers[i].substring(0, 8);
                    vehicleNumber2 = numbers[i].substring(8);
                }
                if(line.contains("VehicleTTT")){
                    line = line.replace("VehicleTTT", vehicleNumber1);
                }
                if(line.contains("NumberTTT")){
                    line = line.replace("NumberTTT", vehicleNumber2);
                }
                newLines.add(line);
            }
            String path = "result_" + i + "_.html";
            Files.write(Paths.get(path), newLines, StandardCharsets.UTF_8);
            newLines.clear();
        }
    }
}
