package army;

import java.util.*;
import java.util.stream.Collectors;

public class VSP_VIN {
    public static void main(String[] args) {
        String[] splitCarNamesAndVin = carNamesAndVin.split("\n");
        List<String> vins = new ArrayList<>();
        for (int i = 0; i < splitCarNamesAndVin.length; i++) {
            List<String> line = Arrays.asList(splitCarNamesAndVin[i].split(" "))
                    .stream()
                    .filter(e -> !e.equals(" ")).collect(Collectors.toList());
            if(!line.isEmpty()) {
                vins.add(line.get(line.size() - 1));
            }
        }
        findAndPrintDuplicates(vins);
    }

    private static void findAndPrintDuplicates(List<String> vins) {
        Set<String> vinUnique = new HashSet<>();
        for (int i = 0; i < vins.size(); i++) {
            if(vinUnique.add(vins.get(i)) == false){
                System.out.println(vins.get(i));
            }
        }
    }

    public static String carNamesAndVin = "КамАЗ-55102 Самоскид-С   5320241417\n" +
            "ЧАРЗ А 092 02 БОГДАН АВТОБУС-D Y7BA092027B001735\n" +
            "ЕТАЛОН А-081.11Ш Автобус-D  Y6PAS8111DP000294\n" +
            "WV1ZZZ7JZ6X024215\n" +
            "ГАЗ-2705  Y6F27050040007182\n" +
            "Volkswagen Transporter WV1ZZZ7HZ4H015436\n" +
            "Volkswagen Transporter  WV2ZZZ70ZYH142080\n" +
            "Renault trafic VF1FLBDB65Y061189\n" +
            "ЗИЛ-131 бортовий-С  41469/3500G\n" +
            "Volkswagen transporter  WV1ZZZ70Z1H032451\n" +
            "ГКБ-8527 Причіп-самоскид-Е  б/н\n" +
            "  \n" +
            "Kia Sorento  KNEJC521535133756\n" +
            "Volkswagen transporter classic  WV1ZZZ7JZ6X024215\n" +
            "УрАЛ-43202   №028203\n" +
            "DAIMLER-BENZ 814F LF8  WDB67408015327534\n" +
            "JEEP GRAND CHEROKKE CRD  1J8HDE8M254572815\n" +
            "МАN 26-463 сідловий тягач    WMAT400189M210934\n" +
            "Citroen Berlingo   VF7GJ9HWC93355926\n" +
            "Kia Sorento   KNEJC521545295163\n" +
            "DAF XF 95.430   XLRTE47XS4E652913\n" +
            "SCHMITZ SCS 24L-1362EB WSM00000003312790\n" +
            "BMW 320D   WBAAP71000PN43182\n" +
            "KRONE SDP 27 причіп  WKESDP27011387662\n" +
            "KIA SORENTO  KNEJC521555384545\n" +
            "RENAULT MAGNUM 480  сідловий тягач-Е VF617GKA000021157\n" +
            "ГАЗ-330232  330230Y0007245\n" +
            "MITSUBISHI L200 вантажнопасажирський-В  MMBJNKB40CDZ00890\n" +
            "Причеп-платформа SCHMITZ S01  WSM00000003032791\n" +
            "RENAULT DUSTER загальний легковий  VF1HSRCFN53484095\n" +
            "RENAULT MIDLUM 220   VF644ACA000005594\n" +
            "МАЗ-500 бортовий-С  26223\n" +
            "УАЗ-3909 вантажопасажирський-В  ХТТ37410220006756\n" +
            "УАЗ-3962 АХШД меддопомога-В  ХТТ37410250437368\n" +
            "Mercedes-benz sprinter меддопомога-В  WDB9066331S649688\n" +
            "ГАЗ-6611    ХТН006611N0707728\n" +
            "Камаз-5320 вантажн.спец. Самоскид  №  0353721\n" +
            "VOLKSWAGEN TRANSPORTER T5пас.-В   WV2ZZZ7HZ7H118429\n" +
            "KIA SORENTO   KNEJC521845313454\n" +
            "УАЗ-452 ЛЄК   309479\n" +
            "HYUNDAI H100  KMFFD17APVU339913\n" +
            "УАЗ-3962  27410050463257\n" +
            "АЦ ГАЗ-3307 Б   1594932\n" +
            "ЗИЛ-131 Автомайстерня-С  896143\n" +
            "FIAT NUOVO DOBLO  ZFA26300006F38320\n" +
            "УАЗ-3303   №   039381\n" +
            "RENAULT MIDLUM 180   VF642AEA000016033\n" +
            "УАЗ-2206  37410030217248\n" +
            "FIAT DUCATO    ZFA25000001897241\n" +
            "ГАЗ-32213 414СПГ  Х9632213070584207\n" +
            "СЗАП 8551   X1W85510A80002878\n" +
            "КамАЗ-55102  6053200243758\n" +
            "МАЗ-5335 бортовий-С  20331\n" +
            "Причіп ГКБ-819   117552\n" +
            "БАЗ А079.03 автобус-D  Y7FA0790350001293\n" +
            "КамАЗ-5320       ХТС532000М0378752\n" +
            "Ford transit    WF0VXXTTFV4D87446\n" +
            "OPEL VIVARO    W0LF7ABA52V621996\n" +
            "MERCEDES-BENZ 508D    30940210380591\n" +
            "FIAT DUCATO     ZFA25000001519549\n" +
            "БОГДАН А22412    Y6LA22412KL100205\n" +
            "RENAULT MASTER T 35 2.8 DTI  VF1FDCCL522660323\n" +
            "VOLKSWAGEN LT46   WV1ZZZ2DZ5H024703\n" +
            "VOLKSWAGEN TRANSPORTER WV1ZZZ70ZWH068245\n" +
            "УАЗ-3962   10000128\n" +
            "VOLKSWAGEN LT 46 FURGON    WV1ZZZ2DZ1X003774\n" +
            "NISSAN T30 X-TRAIL JN1TENT30U0138027\n" +
            "УАЗ-2206 37410070105558\n" +
            "КамАЗ-5320 ХТС532000G0251025\n" +
            "MITSUBISHI L200 ANIMAL D/C 4WD  MMBJNKB407D157398\n" +
            "NISSAN X-TRAIL  JN1TENT30U0137131\n" +
            "Volkswagen transporter  WV2ZZZ70ZRH066823\n" +
            "ЗИЛ-131 Кунг 527793\n" +
            "ГАЗ-66    140910\n" +
            "УАЗ-3962   ХТТ220606Х0042686\n" +
            "УАЗ-3962  ХТТ37410030465524\n" +
            "АС G32214ШДН   27050080391763\n" +
            "УАЗ-3962  37410050216436\n" +
            "Камаз-5320  ХТС532000N1023872\n" +
            "ГАЗ-3302   X9633023062090338\n" +
            "MITSUBISHI L200  MBBJNK7404D037661\n";
}

/*

 */
