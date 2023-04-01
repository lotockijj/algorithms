package army;

public class Test3 {
    public static final String example =
            "%s %s %s року, паспорт %s, колір %s, шасі № %s двигун № б/н, номерний знак %s.\n";

    public static void main(String[] args) {
        String[] carMarkeArr = carMarka.split("\n");
        String[] carModelArr = carModel.split("\n");
        String[] carVINArr = carVIN.split("\n");
        String[] carRegistrationNumberArr = carRegistrationNumber.split("\n");
        String[] carYearArr = carYear.split("\n");
        String[] colourArr = colour.split("\n");
        String[] passportArr = passport.split("\n");
        for (int i = 0; i < carMarkeArr.length; i++) {
            System.out.printf(example,carMarkeArr[i], carModelArr[i], carYearArr[i], passportArr[i], colourArr[i].toLowerCase(), carVINArr[i], carRegistrationNumberArr[i]);
        }
        System.out.println();
        for (int i = 0; i < carMarkeArr.length; i++) {
            System.out.print(carMarkeArr[i] + " " + carModelArr[i] + ", ");
        }
    }
    
    public static final String carMarka = "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Nissan\n" +
            "Nissan\n" +
            "Land\n" +
            "Land\n" +
            "Toyota\n" +
            "Toyota\n" +
            "Ford\n" +
            "Chevrolet\n" +
            "Mitsubishi\n";
    public static final String carModel = "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Hilux\n" +
            "Navara\n" +
            "Navara\n" +
            "Rover\n" +
            "Rover\n" +
            "Land Cruiser\n" +
            "Land Cruiser\n" +
            "Ranger\n" +
            "GMC\n" +
            "Shogun\n";
    public static final String carVIN = "AHTFR22G806033835\n" +
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
    public static final String carRegistrationNumber = "1021И2\n" +
            "1022И2\n" +
            "1023И2\n" +
            "1024И2\n" +
            "1025И2\n" +
            "1026И2\n" +
            "1027И2\n" +
            "1028И2\n" +
            "1029И2\n" +
            "1030И2\n" +
            "1031И2\n" +
            "1032И2\n" +
            "1033И2\n" +
            "1034И2\n" +
            "1035И2\n" +
            "1036И2\n" +
            "1037И2\n" +
            "1038И2\n" +
            "1039И2\n";
    public static final String carYear = "2010\n" +
            "2010\n" +
            "2007\n" +
            "2008\n" +
            "2009\n" +
            "2010\n" +
            "2011\n" +
            "2014\n" +
            "2012\n" +
            "2010\n" +
            "2011\n" +
            "2011\n" +
            "2011\n" +
            "2011\n" +
            "2002\n" +
            "2002\n" +
            "2005\n" +
            "2004\n" +
            "2005\n";
    public static final String passport = "НЕУ00353\n" +
            "НЕУ00354\n" +
            "НЕУ00355\n" +
            "НЕУ00356\n" +
            "НЕУ00357\n" +
            "НЕУ00358\n" +
            "НЕУ00359\n" +
            "НЕУ00360\n" +
            "НЕУ00361\n" +
            "НЕУ00362\n" +
            "НЕУ00363\n" +
            "НЕУ00364\n" +
            "НЕУ00365\n" +
            "НЕУ00366\n" +
            "НЕУ00367\n" +
            "НЕУ00368\n" +
            "НЕУ00369\n" +
            "НЕУ00370\n" +
            "НЕУ00371\n";
    public static final String colour = "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n";
}
