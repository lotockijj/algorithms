package army;

public class Control_Request {

    public static void main(String[] args) {
        String[] split = carsDetails.split("\n");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            String x = split[i].split("\t")[1];
            System.out.println(x.toUpperCase());
        }
    }

    private static final String carsDetails = "SSANGYONG REXTON\tKPTG0B1FS4P164868\t2585C9\n" +
            "NISSAN X-TRAIL\tJN1TENT30U0135951\t2588C9\n" +
            "VOLKSWAGEN SHARAN\tWVWZZZ7MZ1V055577\t6248H9\n" +
            "VOLKSWAGEN T4\tWV1ZZZ70ZWX081940\t2590C9\n" +
            "MITSUBISHI L200\tMMBJNK7405D021395\t2027P9\n" +
            "MITSUBISHI L200\tMMBJNKB407D004997\t6414H9\n" +
            "FORD TRANSIT 260\tWF0VXXBDFV2R59752\t8816H9\n" +
            "MITSUBISHI L200\tMMBJNK7403D027155\t2336P9\n" +
            "FORD TRANSIT \tWF01XXTTG1EJ25095\t6045H9\n" +
            "MITSUBISHI L200\tMMBCNK7405D029250\t8817H9\n" +
            "FORD RANGER\tWF0LMBE107W671348\n" +
            "MITSUBISHI PAJERO SPORT\tJMB0NK940XP005715\n" +
            "MITSUBISHI L200\tMMBJNK7402D012345\t6037H9\n" +
            "MITSUBISHI\tMMBJRKB407D015954\t6186H9\n" +
            "Volkswagen тransporter\tWV2ZZZ70ZPH001581\t6034H9\n" +
            "MITSUBISHI\tMMBJNK7405D001972\t6192H9\n" +
            "ISUZU \tMPATFS85H8T100047\t6147H9\n" +
            "MERCEDES ML 270\tWDC1631132A503377\t6204Н9\n" +
            "NISSAN X- TRAIL\tJN1TENT30U0097204\t2344Р9\n" +
            "HUNDAI TERRACAN\tKMHNM81XP5U151188\t2298Р9\n" +
            "NISSAN NAVARA\tJN1BPUD22U0079812\n" +
            "OPEL CAMPO\tJAATFS54HR7100636\t6243Н9\n" +
            "SsangYong Kyron\tkpts0a1ks6p024737\n" +
            "Mercedes-Benz Sprinter\twdb9036631r608731\n" +
            "Nissan Х-TRIL\tJN1TENT30U0039258\n" +
            "NISSAN NAVARA\tJN1BPUD22U0094861\t6172H9\n" +
            "FIAT AVTO\tZFA23000005733108\t6174H9";
}
