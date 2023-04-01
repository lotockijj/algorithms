package army.vin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Finder {

    public static void main(String[] args) {
        List<String> vins_From_Nakaz = getVinCodesFromString(Nakaz_Constants.vinCodes);
        List<String> vins_From_OOC = getVinCodesFromString(OOC_Vins.vinCodes);
        List<String> vins_From_Border = getVinCodesFromString(VinsFromBorder.vinCodes);
        List<String> vins_From_VolunteerBrigade = getVinCodesFromString(VolunteerBrigade.vinCodes);
        //findAndPrintInterSection(vins_From_Nakaz, vins_From_Border);
        //findAndPrintInterSection(vins_From_OOC, vins_From_Border);
        findAndPrintInterSection(vins_From_VolunteerBrigade, vins_From_Border);
        //findAndPrintInterSection(vins_From_Nakaz, vins_From_VolunteerBrigade);
    }

    private static void findAndPrintInterSection(List<String> vins_From_Nakaz, List<String> vins_From_Border) {
        List<String> vins_from_nakaz = vins_From_Nakaz.stream().filter(e -> vins_From_Border.contains(e)).collect(Collectors.toList());
        printVins(vins_from_nakaz);
    }

    private static void printVins(List<String> vinsFromNakazInBorder) {
        System.out.println("Size: " + vinsFromNakazInBorder.size());
        vinsFromNakazInBorder.forEach(e -> System.out.print(e + ", "));
    }

    private static List<String> getVinCodesFromString(String vinCodes) {
        List<String> strings = Arrays.asList(vinCodes.split("\n")).stream()
                .filter(e -> !e.equals(""))
                .filter(e -> !e.equals("\n"))
                .map(e -> e.replace("№", ""))
                .map(e -> e.replace(" ", ""))
                .collect(Collectors.toList());
        return strings;
    }
}
