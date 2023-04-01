package army;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;
import java.util.stream.Collectors;

public class Registration {

    public static void main(String[] args) {
        String[] carsNames = sourceOfCars.split(",");
        String[] carsData = sourceOfNumbers.split("\n");
        List<Car> cars = createCars(carsNames, carsData);
        checkForDuplicate(cars, "passport");
        checkForDuplicate(cars, "vehicleNumber");
        checkForDuplicate(cars, "registrationNumber");
    }

    private static List<Car> createCars(String[] carsNames, String[] carsData) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNames.length; i++) {
            String[] carsDataSplit = carsData[i].split(" ");
            List<String> carsDataSplitTrim = Arrays.asList(carsDataSplit).stream().map(e -> e.trim()).filter(e -> !"".equals(e)).collect(Collectors.toList());
            Car car = new Car(carsNames[i], carsDataSplitTrim.get(0), carsDataSplitTrim.get(1), carsDataSplitTrim.get(2), carsDataSplitTrim.get(3));
            cars.add(car);
            cars.forEach(e -> System.out.println(e));
        }
        return cars;
    }

    private static void checkForDuplicate(List<Car> cars, String fieldToCheck) {
        Set<String> duplicates = new HashSet<>();
        List<String> stringsToCheck = cars.stream().map(car -> {
            switch (fieldToCheck){
                case("passport") : return car.getPassport();
                case("vehicleNumber") : return car.getVehicleNumber();
                case("registrationNumber") : return car.getRegistrationNumber();
                }
                return null;
        }).collect(Collectors.toList());
        for (String name : stringsToCheck) {
            if (duplicates.add(name) == false) {
                System.out.println(name);
            }
        }
    }

    private static String sourceOfCars = "" +
            "УРАЛ-4320 (АТМЗ-5), УРАЛ-4320 (АТМЗ-5), ЗІЛ-4505, ГАЗ-66, УАЗ-396294ШД, БАЗ А079.23, ГАЗ-6611, Mersedes-benz, БАЗ А079.32, Mersedes-benz, УАЗ-3962, АС-G 32214 ШМДА-2, МАЗ-54322, Автобус МАN, ГАЗ-33023, ГАЗ-33023, ЗИЛ-431410, ЛАЗ-695НГ, ЗИЛ-130, причіп МАЗ-8926, Geep G-Cherokee, ЗИЛ-131," +
            "ЗИЛ-131, FIAT DUCATO, FORD TRANSIT, УАЗ-469, RENAULT MASTER, ГАЗ-66, ГАЗ-330232-414, Volkswagen Transporter, УАЗ-3962, Mercedes-benz, ЗИЛ-131, КрАЗ-65055, Mercedes-benz, МАЗ-555102-223, БАЗ А079.31Ш, КамАЗ-5410, IVECO 35S, УрАЛ-43202, ГАЗ-2705ШД, БАЗ А079.14З," +
            "Toyota land cruiser prado,  КамАЗ-5320,  ГАЗ-3302, УАЗ-3962, МАЗ-500, УАЗ-3962, Mercedes-benz, Mercedes-benz, ГАЗ-6611, АС G32214ШДН, УАЗ-3909, УАЗ-3962, ГАЗ-66, АТАМАN D093, FIAT SCUDO, Mercedes-benz, ГАЗ-66, ГАЗ-66,  ATAMAN D-093S2, причеп ОДАЗ 9370," +
            "УАЗ-2206, Volkswagen LT46,  УАЗ-3303, Renault Midlum, Renault Duster, Fiat Nuovo Doblo, ЗИЛ-131, УАЗ-3962, АЦ ГАЗ-3307Б, Hyndai H100, Opel Frontera, Opel Frontera, КамАЗ-55102, Volkswagen T4, ГАЗ-66, Mitsubishi L200, УАЗ-3303, УАЗ-452, Volkswagen transporter T-5, КамАЗ-5320";

    private static String sourceOfNumbers =
            "1987 БЖ№309264 084545 2716С9.\n" +
            "1985 БД№785396 043680  2719С9.\n" +
            "1990 НЕУ№00063 ХТР450500L3067793 1927И7.\n" +
            "1975 НЕУ№00068 140910  1944И7.\n" +
            "2008 НЕУ№00065 XTT37419480448487  1939И7.\n" +
            "2008 НЕУ№00102 38122585L72796  1964И7.\n" +
            "1992 НЕУ№00140 ХТН00661N0701582  2081И7.\n" +
            "1982 НЕУ№00121 30940210380591  2011И7.\n" +
            "2013 НЕУ№00137 Y7FAS7931D0011386  1980И7.\n" +
            "1995 НЕУ№00138 WDB6740121K092392  2082И7.\n" +
            "1999 НЕУ№00119 ХТТ220606Х0042686  2009И7.\n" +
            "2013 НЕУ№00117 Y8XG24VH0E0006008  1971И7.\n" +
            "1993 НЕУ№00116 19835  1973И7.\n" +
            "1995 НЕУ№00056 WMA4691758G095134  1933И7.\n" +
            "2007 НЕУ№00057 33023060061705  1932И7.\n" +
            "2000 НЕУ№00090  330230Y0007245  0205И2.\n" +
            "1990 НЕУ№00071  L2986243  1924И7.\n" +
            "1991 НЕУ№00053  XTW695000M0155215  1928И7.\n" +
            "1984 НЕУ№00066  443353/3200  1929И7.\n" +
            "1981 НЕУ№00069  2195  1998И7.\n" +
            "2007 НЕУ№00070  1J8HDE8MX7Y530105  1945И7.\n" +
            "1996 НЕУ№00106  625662  1969И7.\n" +
            "1974 НЕУ№00086 137143  1951И7.\n" +
            "1998 НЕУ№00099 ZFA23000005585882  1960И7.\n" +
            "1999 НЕУ№00091 WF0LXXGBVLXJ18199  1955И7.\n" +
            "1978 НЕУ№00095 283724  1957И7.\n" +
            "2015 НЕУ№00093 WF1MAFECC52909429 1966И7.\n" +
            "1990 НЕУ№00092 ХТН006614L0620303 1954И7.\n" +
            "2008 НЕУ№00078 X9633023080633672 1940И7.\n" +
            "1997 НЕУ№00077 WV1ZZZ70ZWH045156 1941И7.\n" +
            "2007 НЕУ№00062 37410070215990  1934И7.\n" +
            "2002 НЕУ№00061 WBB9036121R396983  1926И7.\n" +
            "1985 НЕУ№00100 436741/3200  1962И7.\n" +
            "2007 НЕУ№00058 Y7A65055080808355  1931И7.\n" +
            "2004 НЕУ№00072 WDB9036631R596040  1922И7.\n" +
            "2008 НЕУ№00067 Y3M55510280012747 1923И7.\n" +
            "2013 НЕУ№00073 Y7FAS931D0011381 1942И7.\n" +
            "1993 НЕУ№00104 ХТС541000Р2047413  1956И7.\n" +
            "2003 НЕУ№00080 ZCFC3562105389182  1943И7.\n" +
            "1984 НЕУ№00076 028203  1921И7.\n" +
            "2008 НЕУ№00101 Х9627050080600782 1963И7.\n" +
            "2006 НЕУ№00107 Y7FA0791460002803 1968И7.\n" +
            "2019 НЕУ№00074 JTEBX3FJ40K322520 1937И7.\n" +
            "1992 НЕУ№00155 ХТС532000N1023872 2028И7.\n" +
            "2005 НЕУ№00109 X9633023062090338 2004И7.\n" +
            "2005 НЕУ№00157 37410050464728 2032И7.\n" +
            "1968 НЕУ№00158 26233  2030И7.\n" +
            "2005 НЕУ№00161 ХТТ37410250437368 2031И7.\n" +
            "2019 НЕУ№00136 WDB9066331S649688 2020И7.\n" +
            "2003 НЕУ№00130 WDB9036121R537465 1975И7.\n" +
            "1992 НЕУ№00148 ХТН006611N0707728 2027И7.\n" +
            "2008 НЕУ№00151 X9627050080615782 2024И7.\n" +
            "2002 НЕУ№00149 ХТТ37410220006756 2026И7.\n" +
            "2003 НЕУ№00126 ХТТ37410030465524 2015И7.\n" +
            "1998 НЕУ№00154 ХТН006615Н0516084 1982И7.\n" +
            "2021 НЕУ№00096 Y7BD093S2MB000068 1958И7.\n" +
            "1998 НЕУ№00097 ZFA138A0002953140 1959И7.\n" +
            "1999 НЕУ№00088 WDB9034621P935948 1949И7.\n" +
            "1971 НЕУ№00098 263153  1961И7.\n" +
            "1979 НЕУ№00120 0049289  1972И7.\n" +
            "2017 НЕУ№00087 Y7BD093S2HB000274  1950И7.\n" +
            "1985 НЕУ№00103 129101 9299Ж1.\n" +
            "2003 НЕУ№00150 37410030217248  2025И7.\n" +
            "2005 НЕУ№00160 WV1ZZZ2DZ5H024703  2029И7.\n" +
            "1986 НЕУ№00159 039381  2033И7.\n" +
            "2004 НЕУ№00112 VF642AEA000016033 2007И7.\n" +
            "2019 НЕУ№00153 VF1HJD40664630378 1981И7.\n" +
            "2017 НЕУ№00111 ZFA26300006F38320 2006И7.\n" +
            "1989 НЕУ№00122 896143 2010И7.\n" +
            "2005 НЕУ№00127 27410050463257  2016И7.\n" +
            "1994 НЕУ№00123 1594932  2014И7.\n" +
            "1997 НЕУ№00124 KMFFD17APVU339913  2013И7.\n" +
            "2000 НЕУ№00081 W0L06BG761V603467  1948И7.\n" +
            "2001 НЕУ№00084 W0L06BG761V501341  1953И7.\n" +
            "1983 НЕУ№00094 5320072217  1965И7.\n" +
            "1999 НЕУ№00085 WV1ZZZ70ZXH092412  1952И7.\n" +
            "1983 НЕУ№00064 0484332  1946И7.\n" +
            "2003 НЕУ№00083 MBBJNK7404D037661  2003И7.\n" +
            "1989 НЕУ№00075 б/н  1947И7.\n" +
            "1983 НЕУ№00125 309479  2012И7.\n" +
            "2007 НЕУ№00128 WV2ZZZ7HZ7H118429  2017И7.\n" +
            "1990 НЕУ№00110 0353721  2005И7.";
}
