package army.nakaz;/* Львівський      И7 1921-2001 - 80 шт.
                   Ж1 9298-9303 - 5 шт.
   Тернопільський  И7 2002-2082 - 80 шт.
                   Ж1 9304-9309 - 5 шт.
*/
/* 3МР командира 3 стрілецької роти 1 стрілецького батальйону капітана ЯЦУЛЯКА Миколу Мироновича
1МР командира 1 стрілецької роти 1 стрілецького батальйону капітана КЛОСА Василя Ярославовича
МТЗ командира взводу матеріального-технічного забезпечення 1 стрілецького батальйону головного сержанта БОДНАРА Ярослава Юрійовича
*/

public class Nakaz {

    private static String vehicleNumbers = "28203\n" +
            "WDB9036631R596040\n" +
            "Y3M55510280012747\n" +
            "L2986243\n" +
            "Відчужений\n" +
            "Відчужений\n" +
            "Відчужений\n" +
            "WV1ZZZ70ZWH069175\n" +
            "WBB9036121R396983\n" +
            "XTP450500L3067793\n" +
            "XTW695000M0155215\n" +
            "443353/3200\n" +
            "VF1HSRCFN53484095\n" +
            "Y7A65055080808355\n" +
            "33023060061705\n" +
            "WMA4691758G095134\n" +
            "37410070215990\n" +
            "WDB9036611R70\n" +
            "HAATFSJ9HX7100516\n" +
            "JTEBX3FJ40K322520\n" +
            "JN1TENT30U0229805\n" +
            "XTT37419480448487\n" +
            "X9633023080633672\n" +
            "WV1ZZZ70ZWH045156\n" +
            "Y7FAS931D0011381\n" +
            "ZCFC3562105389182\n" +
            "140910\n" +
            "2195\n" +
            "VIN:1J8HDE8MX7Y530105\n" +
            "484332\n" +
            "б\\н\n" +
            "KNEJC521845313454\n" +
            "MBBJNK7404D037661\n";

    private static String names = "УрАЛ-43202\n" +
            "Mercedes-benz sprinter 311CDI автобус-D\n" +
            "МАЗ-555102-223 САМОСКИД-С\n" +
            "ЗИЛ-131 БОРТОВИЙ-С\n" +
            "CITROEN JUMPY легковий \n" +
            "RENAULT MASTER спец вантажний Фургон\n" +
            "СITROEN BERLINGO фургон малотонажний-В\n" +
            "Volkswagen Transporter\n" +
            "Mercedes-benz sprinter вантажний фургон\n" +
            "ЗИЛ-4505 Самоскид-С\n" +
            "ЛАЗ-695НГ Автобус\n" +
            "ЗИЛ-130 Бортовий-С\n" +
            "RENAULT DUSTER Загальний легковий\n" +
            "КрАЗ-65055 Самоскид-С\n" +
            "ГАЗ-330232 212 Бортовий малотонажний\n" +
            "MAN-11.230 Загальний автобус\n" +
            "УАЗ-3962 Мікроавтобус меддопом-D\n" +
            "Mercedes-benz sprinter Автобус\n" +
            "Opel Campo S\n" +
            "TOYOTA LAND CRUISER PRADO 150\n" +
            "NISSAN X-TRAIL 2.2TDI\n" +
            "УАЗ-396294ШД мікроавто меддопом-D\n" +
            "ГАЗ-330232-414 вантажний загальний\n" +
            "Volkswagen Transporter\n" +
            "БАЗ А079.31Ш   Автобус-D\n" +
            "IVECO 35S фургон малотонажний-В\n" +
            "ГАЗ-66 \n" +
            "МАЗ-8926 причіп бортовий-Е\n" +
            "Jeep Grand Cherokee\n" +
            "ГАЗ-66 \n" +
            "УАЗ-3303\n" +
            "KIA SORENTO\n" +
            "MITSUBISHI L200 вантажнопасажирський-В\n";

    private static String pattern = "%s, шасі № %s,  відповідальним за зберігання та експлуатацію призначити командира другого стрілецького батальйону " +
            "ГЛУШКА Олександра Васильовича, присвоїти на автомобіль %s військовий номерний знак 20-%dИ7.";
    private static String patternTrailer = "%s, шасі № %s,  відповідальним за зберігання та експлуатацію призначити командира першого стрілецького батальйону " +
            "ГЛУШКА Олександра Васильовича, присвоїти на причеп %s військовий номерний знак 92-%dЖ7.";
    private static int numberOfCarsStart = 10;
    private static int numberOfTrailersStart = 99;
    private static String startFirstStr = "19-85И7"; // 1999И7 ГМЗ дали 9309Ж1 причеп
    private static String startSecondStr = "20-42И7";

    public static void main(String[] args) {
        String[] namesArray = namesAdd_2StrB2.split("\\n");
        String[] vehicleArray = vehicleNumbersAdd_2StrB2.split("\\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < namesArray.length; i++) {
            if(vehicleArray[i].equals("Відчужений")) {
                continue;
            }
            if(i == 100000000) {
                result.append(String.format(patternTrailer, namesArray[i], vehicleArray[i], namesArray[i], numberOfTrailersStart++)).append("\n");
            } else {
                result.append(String.format(pattern, namesArray[i], vehicleArray[i], namesArray[i], numberOfCarsStart++)).append("\n");
            }
        }
        System.out.println(result + "\n + " + vehicleArray.length);
    }

    private static String vehicleNumbersAdd1 = "W0L06BG761V603467\n" +
            "WDB9034621P935948\n" +
            "Y7BD093S2HB000274\n" +
            "137143\n" +
            "WV1ZZZ70ZXH092412\n" +
            "W0L06BG761V501341\n" +
            "ХТН006614L0620303\n" +
            "WF0LXXGBVLXJ18199\n" +
            "129101\n" +
            "ХТС541000Р2047413\n" +
            "283724\n" +
            "Y7BD093S2MB000068\n" +
            "ZFA138A0002953140\n" +
            "ZFA23000005585882\n" +
            "263153\n" +
            "436741/3200\n" +
            "Х9627050080600782\n" +
            "38122585L72796\n" +
            "5320072217\n" +
            "VF1MAFECC52909429\n" +
            "VF77H9HKCDJ615483\n" +
            "Y7FA0791460002803\n" +
            "625662\n";

    private static String namesAdd1 = "OPEL FRONTERA загальний легковий\n" +
            "MERSEDES-BENZ SPRINTER 310D\n" +
            "ATAMAN D-093S2 спеціалізований автобус\n" +
            "ЗИЛ-131 БОРТОВИЙ-С\n" +
            "VOLKSWAGEN T4 вантажнопасажирський-В\n" +
            "OPEL FRONTERA загальний легковий\n" +
            "ГАЗ-66 фургон пасажирський-СІD\n" +
            "FORD TRANSIT\n" +
            "ОДАЗ 9370 Н/ПРИЧІП-ПЛАТФОРМА-Е\n" +
            "КАМАЗ-5410 сідловий тягач-Е\n" +
            "УАЗ-469\n" +
            "ATAMAN D093/D093S2\n" +
            "FIAN SCUDO загальний легковий \n" +
            "FIAN DUCATO\n" +
            "ГАЗ-66 \n" +
            "ЗИЛ-131 ФУРГОН-С\n" +
            "ГАЗ-2705ШД  меддопомоги\n" +
            "БАЗ А079.23 АВТОБУС-D\n" +
            "КАМАЗ-55102\n" +
            "RENAULT MASTER спец.вантаж. Фургон\n" +
            "СITROEN BERLINGO Фургон малотонажний-В\n" +
            "БАЗ А079.14З ЗАГАЛЬНИЙ АВТОБУС-D\n" +
            "ЗИЛ-131 АЦ40\n";

    private static String vehicleNumbersAdd_2StrB = "X9633023062090338\n" +
            "353721\n" +
            "ZFA26300006F38320\n" +
            "VF642AEA000016033\n" +
            "WV1ZZZ70ZWH068245";

    private static String namesAdd_2StrB = "ГАЗ-3302 Загальний вантажний малотонажний\n" +
            "Камаз-5320 вантажний спеціальний самоскид\n" +
            "FIAT NUOVO DOBLO фургон малотонажн-В\n" +
            "RENAULT MIDLUM 180 спеціальний вантажний\n" +
            "VOLKSWAGEN TRANSPORTER";

    private static String vehicleNumbersAdd_2StrB2 = "896143\n" +
            "30940210380591\n" +
            "309479\n" +
            "KMFFD17APVU339913\n" +
            "1594932\n" +
            "ХТТ37410030465524\n" +
            "27410050463257\n" +
            "WV2ZZZ7HZ7H118429";

    private static String namesAdd_2StrB2 = "ЗИЛ-131 автомайстерня-С\n" +
            "MERCEDES-BENZ 508D загальний бортовий\n" +
            "УАЗ-452 ЛЄК загальний мікроавтобус-D\n" +
            "HYUNDAI H100 фургон малотонажний\n" +
            "АЦ ГАЗ-3307 Б цистерна харчова-С\n" +
            "УАЗ-3962 спеціальний меддопомоги-В\n" +
            "УАЗ-3962 мікроавтобус меддопомоги-D\n" +
            "VOLKSWAGEN TRANSPORTER T5 пасажирський-В";
}
