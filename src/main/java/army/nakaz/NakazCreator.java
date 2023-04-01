package army.nakaz;

public class NakazCreator {

    public static void main(String[] args) {
        String[] splitCars = cars.split("\n");
        String[] splitVins = vins.split("\n");
        String[] splitPositionsAndNames = NakazCreator.positionsAndNames.split("\n");
        int startNumber = 21;
        for (int i = 0; i < splitCars.length; i++) {
            String carName = splitCars[i];
            String carVin = splitVins[i];
            System.out.printf(pattern, carName, carVin, carName, startNumber++);
        }
        startNumber = 21;
        int countPositionAndName = 0;
        System.out.println();
        int count = 0;
        for (int i = 0; i < splitCars.length; i++) {
            String carName = splitCars[i];
            String positionAndName = splitPositionsAndNames[countPositionAndName];
            System.out.printf(pattern2, ++count, carName, startNumber++, positionAndName);
            if(i % 2 == 1) countPositionAndName++;
        }
        startNumber = 21;
        for (int i = 0; i < 19; i++) {
            System.out.println("10" + startNumber + "И2");
            startNumber++;
        }
        String[] splitModelAndYear = modelAndYear.split("\n");
        for (int i = 0; i < splitModelAndYear.length; i++) {
            String[] s = splitModelAndYear[i].split(" ");
            String lastWord = s[s.length - 1];
            System.out.println(lastWord);
        }
        for (int i = 0; i < splitCars.length; i++) {
            System.out.println(splitCars[i]);
        }
    }

    private static final String pattern = "%s, шасі № %s, відповідальним за зберігання та експлуатацію призначити командира роти вогневої підтримки військової частини А0998 майора ТЕРЕЩЕНКО Ярослава Олександровича, присвоїти на автомобіль %s військовий номерний знак 10%dИ2.\n";
    private static final String pattern2 = "2.%d %s  військовий номер 10%dИ2 %s\n";
    private static final String registerNumbers = "1021-1040И2";

    private static final String cars = "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Toyota Hilux\n" +
            "Nissan Navara\n" +
            "Nissan Navara\n" +
            "Land Rover \n" +
            "Land Rover \n" +
            "Toyota Land Cruiser\n" +
            "Toyota Land Cruiser\n" +
            "Ford Ranger\n" +
            "Chevrolet GMC\n" +
            "Mitsubishi Shogun\n";
    private static final String vins = "AHTFR22G806033835\n" +
            "AHTFZ29GX09044310\n" +
            "AHTDR22G105503507\n" +
            "MROFZ29G101710743\n" +
            "MROFR22G500531492\n" +
            "AHTFZ29G509048961\n" +
            "AHTFZ29G109065336\n" +
            "AHTFZ29G209106217\n" +
            "AHTFZ29G909073104\n" +
            "AHTFR22G106027021\n" +
            "VSKCVND40U0444222\n" +
            "VSKCVND40U0430716\n" +
            "SALLAAAG3BA569602\n" +
            "SALLAAA137A428258\n" +
            "JTEBZ99J200032054\n" +
            "JTEAZ99J900011777\n" +
            "WF0LMFE405W435314\n" +
            "MPATF577H4H520422\n" +
            "JMALYV78W5J002754\n";

            private static final String positionsAndNames = "водія гранатометного взводу роти вогневої підтримки військової частини А0998 старшого солдата ГЕРМАНОВИЧ Михайла Григоровича.\n" +
                    "водія гранатометного взводу роти вогневої підтримки військової частини А0998 солдата НАДИЧ Михайла Михайловича.\n" +
                    "водія гранатометного взводу роти вогневої підтримки військової частини А0998 солдата ПАНОЧКО Івана Михайловича.\n" +
                    "водія гранатометного взводу роти вогневої підтримки військової частини А0998 солдата ГНАТИК Олега Івановича.\n" +
                    "водія протитанкового взводу роти вогневої підтримки військової частини А0998 солдата ВОЛОШИН Романа Ігоровича.\n" +
                    "водія протитанкового взводу роти вогневої підтримки військової частини А0998 солдата КОВАЛЬЧУК Петра Юрійовича.\n" +
                    "старшого водія 1 мінометного відділення мінометного взводу роти вогневої підтримки військової частини А0998 старшого солдата ПІК Олександра Івановича.\n" +
                    "водія 2 мінометного відділення мінометного взводу роти вогневої підтримки військової частини А0998 старшого солдата ПОПОВИЧ Анатолія Михайловича.\n" +
                    "водія 3 мінометного відділення мінометного взводу роти вогневої підтримки військової частини А0998 молодшого сержанта ПЕЛЕЩИШИН Олега Володимировича.\n" +
                    "водія 4 мінометного відділення мінометного взводу роти вогневої підтримки військової частини А0998 старшого солдата АТАМАНЧУК Андрія Івановича.\n";

    private static final String modelAndYear = "Toyota Hilux 2010\n" +
            "Toyota Hilux 2010\n" +
            "Toyota Hilux 2007\n" +
            "Toyota Hilux 2008\n" +
            "Toyota Hilux 2009\n" +
            "Toyota Hilux 2010\n" +
            "Toyota Hilux 2011\n" +
            "Toyota Hilux 2014\n" +
            "Toyota Hilux 2012\n" +
            "Toyota Hilux 2010\n" +
            "Nissan Navara 2011\n" +
            "Nissan Navara 2011\n" +
            "Land Rover 2011\n" +
            "Land Rover 2011\n" +
            "Toyota Land Cruiser 2002\n" +
            "Toyota Land Cruiser 2002\n" +
            "Ford Ranger 2005\n" +
            "Chevrolet GMC 2004\n" +
            "Mitsubishi Shogun  2005\n";
}
