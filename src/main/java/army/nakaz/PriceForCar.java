package army.nakaz;

public class PriceForCar {

    public static void main(String[] args) {
        double startPrice = 501670.00;
        double endOfUseBySpeedometer = 800000;
        double oneHundredPercent = 100;
        int endOfUseByYear = 2030;
        // 800000 - speedometer/800000 == 1
        // (2022 - year)*2%
        String[] splitSpeedometer = speedometer.split("\n");
        String[] splitYear = year.split("\n");
        for (int i = 0; i < splitSpeedometer.length; i++) {
            double price = startPrice * ((endOfUseBySpeedometer - Integer.parseInt(splitSpeedometer[i]))/endOfUseBySpeedometer)
                    * ((oneHundredPercent - (2022 - Integer.parseInt(splitYear[i])))/oneHundredPercent);
            System.out.println(String.format("%.2f",price));
        }
    }

    private static String speedometer = "174805\n" +
            "136585\n" +
            "151529\n" +
            "146527\n" +
            "144211\n" +
            "209046\n" +
            "200000\n" +
            "107318\n" +
            "172731\n" +
            "146801\n" +
            "125418\n" +
            "149701\n" +
            "231015\n" +
            "133221\n" +
            "211671\n" +
            "162839\n" +
            "161971\n" +
            "147206\n" +
            "214601\n";

    private static String year = "2010\n" +
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
}
