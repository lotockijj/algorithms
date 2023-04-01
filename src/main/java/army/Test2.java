package army;

public class Test2 {
    private static String str = "Транспортний засіб %s року, паспорт НЕУ№00125, колір %s, шасі %s двигун №б/н, номерний знак %s.";
    private static String shasy = "443353/3200\n" +
            "Y7A65055080808355\n" +
            "33023060061705\n" +
            "WMA4691758G095134\n" +
            "37410070215990\n" +
            "WDB9036611R709283\n" +
            "JTEBX3FJ40K322520\n" +
            "JN1TENT30U0229805\n" +
            "X9633023080633672\n" +
            "WV1ZZZ70ZWH045156\n" +
            "Y7FAS931D0011381\n" +
            "ZCFC3562105389182\n" +
            "140910\n" +
            "2195\n" +
            "1J8HDE8MX7Y530105\n" +
            "б/н\n" +
            "KNEJC521845313454\n" +
            "MBBJNK7404D037661\n" +
            "W0L06BG761V603467\n" +
            "WDB9034621P935948\n" +
            "Y7BD093S2HB000274\n";


    public static void main(String[] args) {
        String[] it = shasy.split("\n");
        String[] yearsArr = years.split("\n");
        String[] coloursArr = colours.split("\n");
        String[] registrationNumbersArr = registrationNumbers.split("\n");
        int start = 6113;
        for (int i = 0; i < it.length ; i++) {
            System.out.println(String.format(str, yearsArr[i], coloursArr[i], it[i], registrationNumbersArr[i], start));
            start++;
        }
        String[] split = names.split("\n");
        for (int i = 0; i < split.length; i++) {
            //System.out.print(split[i] +", ");
        }
    }

    private static String names = "ЗИЛ-130\n" +
            "КрАЗ-65055\n" +
            "ГАЗ-330232 212\n" +
            "MAN-11.230\n" +
            "УАЗ-3962\n" +
            "Mercedes-benz sprinter\n" +
            "TOYOTA LAND CRUISER PRADO 150\n" +
            "NISSAN X-TRAIL 2.2TDI\n" +
            "ГАЗ-330232-414 \n" +
            "Transporter\n" +
            "БАЗ А079.31Ш \n" +
            "\n" +
            "IVECO 35S\n" +
            "ГАЗ-66 \n" +
            "МАЗ-8926 причіп бортовий-Е\n" +
            "Jeep Grand Cherokee\n" +
            "УАЗ-3303\n" +
            "KIA SORENTO\n" +
            "MITSUBISHI L200 \n" +
            "OPEL FRONTERA\n" +
            "MERSEDES-BENZ SPRINTER 310D\n" +
            "ATAMAN D-093S2\n" +
            "спеціалізований автобус\n";
    private static String years = "1984\n" +
            "2007\n" +
            "2006\n" +
            "1995\n" +
            "2007\n" +
            "2004\n" +
            "2019\n" +
            "2006\n" +
            "2008\n" +
            "1997\n" +
            "2013\n" +
            "2003\n" +
            "1975\n" +
            "1981\n" +
            "2007\n" +
            "1989\n" +
            "2004\n" +
            "2003\n" +
            "2000\n" +
            "1999\n" +
            "2017\n";

    private static String colours = "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Сірий\n" +
            "Зелений\n" +
            "Білий\n" +
            "Зелений\n" +
            "Сірий металік\n" +
            "Зелений\n" +
            "Синій\n" +
            "Жовтий\n" +
            "Білий\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Чорний\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Зелений\n" +
            "Синій\n" +
            "Зелений\n" +
            "Жовтий\n";

    private static String registrationNumbers = "1929И7\n" +
            "1931И7\n" +
            "1932И7\n" +
            "1933И7\n" +
            "1934И7\n" +
            "1935И7\n" +
            "1937И7\n" +
            "1938И7\n" +
            "1940И7\n" +
            "1941И7\n" +
            "1942И7\n" +
            "1943И7\n" +
            "1944И7\n" +
            "9300Ж1\n" +
            "1945И7\n" +
            "1947И7\n" +
            "2002И7\n" +
            "2003И7\n" +
            "1948И7\n" +
            "1949И7\n" +
            "1950И7\n";
}
