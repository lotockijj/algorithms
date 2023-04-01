package army;

public class Test4 {

    public static void main(String[] args) {
        String[] modelArr = model.split("\n");
        String[] vinArr = vin.split("\n");
        for (int i = 0; i < modelArr.length; i++) {
            System.out.println(modelArr[i] + " " + vinArr[i]);
        }
    }

    private static final String model = "VOLKSWAGEN TRANSPORTER\n" +
            "ЗИЛ-431412 \n" +
            "УрАЛ-4320 АТМЗ-5 \n" +
            "УрАЛ-4320 АТМЗ-5 \n" +
            "ЗИЛ-131 П-238ТМ\n" +
            "VOLKSWAGEN LT46 фургон малотонаж.-В\n" +
            "КамАЗ-5320 вантажний загальний бортовий\n" +
            "ЗИЛ-131 бортовий-С кузов L885930\n" +
            "LAND ROVER FREELANDER \n" +
            "ГАЗ-66 автофургон\n" +
            "Renault trafic\n" +
            "Volkswagen Transporter 1.9D\n" +
            "ЗИЛ-131 вантажний\n" +
            "ЗИЛ-131 вантажний\n" +
            "MERSEDES-BENZ VARIO, DST 13361\n" +
            "MiTSUBISHI L200 \n" +
            "Mersedes-Benz Unimog\n" +
            "Mersedes-Benz Unimog\n" +
            "MERSEDES-BENZ ACTROS 1841\n" +
            "АЦ-5,5-4320\n" +
            "Причіп-цистерна ПЦ-9-8350\n" +
            "МАN 26-463 сідловий тягач\n" +
            "2С1\n" +
            "HMMWV M1152 4x4 автомобіль санітарний\n" +
            "DAIMLER-BENZ 814F LF8\n" +
            "УрАЛ-4320(КЕТ-Л)\n" +
            "JEEP GRAND CHEROKKE CRD\n" +
            "КамАЗ-4310\n" +
            "ЕТАЛОН А-081.11Ш Автобус-D\n" +
            "Hyundai Motor ШИМАНСЬКИЙ Андрій Вікторович\n" +
            "УрАЛ-4320 (БМ-21 “ГРАД”)\n" +
            "УрАЛ-4320 (БМ-21 “ГРАД”)\n" +
            "АЦ-5,5-4320\n" +
            "КамАЗ-65117 вантажний самоскид\n" +
            "НЕФАЗ загальний причеп ПР-бортовий-Е\n" +
            "Mercedes-benz 108D\n" +
            "MiTSUBISHI L200 \n" +
            "MiTSUBISHI L200 \n" +
            "Renault Master \n" +
            "ГАЗ-33023 212\n" +
            "МАЗ-53366 вантажний, бортовий\n" +
            "ЗИЛ-131 \n" +
            "Hyundai Terracan\n" +
            "Volkswagen Transporter T4 131LMB\n" +
            "Suzuki Grand Vitara\n" +
            "КамАЗ-55102ПЕ\n" +
            "КамАЗ-45144 самоскид-С\n" +
            "Mercedes-benz 711D\n" +
            "MiTSUBISHI L200 \n" +
            "Mercedes-benz Vito 108CDI\n" +
            "VOLKSWAGEN TRANSPORTER\n" +
            "Dodge Journey\n" +
            "Hyundai Santa Fe\n" +
            "Renault Master швидка допомога\n" +
            "Toyota Hilux\n" +
            "Volkswagen Transporter T4\n" +
            "Fiat Ducato\n" +
            "ГМ-352\n" +
            "PEUGEOT BOXER\n" +
            "NISAN NAVARA\n" +
            "MiTSUBISHI L200 \n" +
            "MЕRSEDES BENZ\n" +
            "Renault Magnum 480 вантажний сідловий тягач\n" +
            "2С1 “Гвоздика”\n" +
            "2С1 “Гвоздика”\n" +
            "2С1 “Гвоздика”\n" +
            "2С1 “Гвоздика”\n" +
            "2С1 “Гвоздика”\n" +
            "Kia Sorento\n" +
            "МАN 26-463 сідловий тягач\n" +
            "ISUZU D-MAX CREW CAB IS 4DR\n" +
            "Volkswagen Transporter\n" +
            "LAND ROVER FREELANDER \n" +
            "Трал-негабарит VEREM\n" +
            "Peugeot Landtrek\n" +
            "Mercedes-benz Sprinter \n" +
            "УАЗ-3163-010 легковий універсал-В\n" +
            "FORD TRANSIT фургон малотонажний-В\n" +
            "КамАЗ-55102\n" +
            "Причеп ГКБ-8350\n" +
            "КамАЗ-55102 Самоскид-С\n" +
            "НЕФАЗ-8560 причіп пр-самоскид-Е\n" +
            "HYUNDAI HD72 вантажний-спеціалізований фургон ізотермічний-С\n" +
            "Mercedes-Benz Sprinter 413 CDI\n" +
            "Renault Dokker спеціалізований вантажний фургон малотонажний-В\n" +
            "Toyota Hilux вантажний пікап\n" +
            "MiTSUBISHI L200 \n" +
            "Land Rover Freelander загальний легковий повнопривідний\n" +
            "Оpel Vivaro\n" +
            "TOYOTA LANDCRUISER\n" +
            "TOYOTA LANDCRUISER\n" +
            "TOYOTA LANDCRUISER\n" +
            "Toyota HiAce 4WD вантажний\n" +
            "Volkswagen Transporter\n" +
            "КамАЗ-45142\n" +
            "Причіп НЕФАЗ-8560\n" +
            "Ford Transit загальний легковий пасажирський-В\n" +
            "КамАЗ-53211\n" +
            "ЗИЛ-ММЗ\n" +
            "ACKERMANN PA – 18 – 7.1E загальний причіп пр-бортовий-Е\n" +
            "СЗАП-8355 причіп бортовий-Е\n" +
            "МАЗ-6317 (лазня)\n" +
            "Причіп МАЗ-857100-5010 (лазня)\n" +
            "Ssang Yong Rexton\n" +
            "Fiat Ducato\n" +
            "MiTSUBISHI L200 \n" +
            "Volkswagen Transporter\n" +
            "ГАЗ-3302-757 вантажний — загальний  бортовий\n" +
            "FS Lublin 3mi\n" +
            "Volkswagen Transporter T4\n" +
            "Toyota RAV4\n" +
            "САРМ-С(66)\n" +
            "САРМ-С(66)\n" +
            "ГАЗ-330202–388\n" +
            "Renault Duster легковий — загальний універсал-В\n" +
            "Toyota Hiace  \n" +
            "УАЗ-3151\n" +
            "УАЗ-469\n" +
            "Renault Master \n" +
            "ГАЗ-5201\n" +
            "Renault Trafic\n" +
            "ГАЗ-66\n" +
            "ГАЗ-66\n" +
            "MERSEDES-BENZ ACTROS 1841 спеціалізований вантажний сідловий тягач-Е\n" +
            "ГМ-352\n" +
            "MAN TGX 18.440 спеціалізований сідловий тягач-Е\n" +
            "SCHMITZ SCS 24L-1362EB загальний напівпричіп — бортовий тентований\n" +
            "Volkswagen Transporter\n" +
            "Volkswagen Transporter\n" +
            "Volkswagen Transporter\n" +
            "Volkswagen Transporter 2,5 TDI\n" +
            "MiTSUBISHI L200 \n" +
            "Volkswagen Transporter\n" +
            "Volvo B12M Contrast\n" +
            "УрАЛ-4320\n" +
            "Mitsubishі L200\n";
    private static final String vin ="WV1ZZZ70ZWH068245\n" +
            "3327453\n" +
            "043680\n" +
            "0845450\n" +
            "476876\n" +
            "WV1ZZZ2DZ5H024703\n" +
            "ХТС532000G0251025\n" +
            "41469/3500G\n" +
            "SALLNABA7XA672115\n" +
            "480978\n" +
            "VF1FLBDB65Y061189\n" +
            "WV2ZZZ70ZPH014836\n" +
            "418093\n" +
            "849416\n" +
            "WDB6703531N118050\n" +
            "MMBJRKB408D060969\n" +
            "WDB4351151W144342\n" +
            "WDB4351151W142538\n" +
            "WDB9340321L143711\n" +
            "180256\n" +
            "L0035531\n" +
            "WMAT400189M210934\n" +
            "8401005\n" +
            "380056\n" +
            "WDB67408015327534\n" +
            "№0147047\n" +
            "1J8HDE8M254572815\n" +
            "27555\n" +
            "Y6PAS8111DP000294\n" +
            "KMHSC81VP4U713150\n" +
            "№ 043728\n" +
            "№ 073329\n" +
            "№ 030223\n" +
            "ХТС651170С1242991\n" +
            "X1F833200C0007019\n" +
            "VSA63809413249423\n" +
            "MMBNGV547NH011865\n" +
            "MMBNGV540NН012405\n" +
            "VF1FDAGD525248047\n" +
            "Х9633023052038857\n" +
            "Y3M53366010010492\n" +
            "450240\n" +
            "KMHNM81XP2U024936\n" +
            "WV1ZZZ70Z2H103674\n" +
            "JSAFTD82V00120949\n" +
            "363198/190010005320241983\n" +
            "ХТС65115082347398\n" +
            "WDB66706310920218\n" +
            "MMBJNK7401D033570\n" +
            "VSA63809413374279\n" +
            "WV1ZZZ7HZ8H108667\n" +
            "3D4GH57V09T585199\n" +
            "KMHSB81VP4U640192\n" +
            "VF6MFF4BR44182343\n" +
            "AHTFR22G606110895\n" +
            "WV2ZZZ70ZVH030536\n" +
            "ZFA24400007038206\n" +
            "Ж17ПТ2126\n" +
            "VF3YBZMFB12300072\n" +
            "VSKBVND40U0129464\n" +
            "MMBJNKL30N056233\n" +
            "WDB6703222N130981\n" +
            "VF617GSA000006506\n" +
            "2205009\n" +
            "2205010\n" +
            "2205002\n" +
            "2205018\n" +
            "2205006\n" +
            "KNEJC521555473398\n" +
            "WMAT400189M210934\n" +
            "MPATFS77H6H580309\n" +
            "WV1ZZZ70ZXH003081\n" +
            "SALLNAAE71A318274\n" +
            "VF9VP3342N3398152\n" +
            "VR3FDANDJM3005200\n" +
            "WDB9061532N631593\n" +
            "31630060000536\n" +
            "WF0LXXGBVLVD74995\n" +
            "5320230154\n" +
            "207120\n" +
            "ХТС532000К0352259\n" +
            "X1F85600020001361\n" +
            "Y6LHD72188L100380\n" +
            "WDB9046131R526325\n" +
            "VF18SRPL457780365\n" +
            "MR0HB3CD300404179\n" +
            "MMBJNKL30NH055901\n" +
            "SALLNABA8XA662601\n" +
            "W0LF7ABA54V637253\n" +
            "JTEEB71J100F004244\n" +
            "JTEEB71J80F004192\n" +
            "JTEBB71J90B035560\n" +
            "JT121JK2800012151\n" +
            "WV1ZZZ7HZ5H093028\n" +
            "ХТС53229R82346656\n" +
            "X1F8560E070011545\n" +
            "WF0KXXGBVKKC83363\n" +
            "53200295205\n" +
            "2666953\n" +
            "WAFXXXXXXSZ014751\n" +
            "79262/5400G\n" +
            "Y3M631727L0000045\n" +
            "Y3M857100L0007727\n" +
            "KPTG0B1FS5P187133(01)\n" +
            "ZFA23000005021514\n" +
            "MMBJJKL10PH022092\n" +
            "WV1ZZZ7HZ4H007122\n" +
            "X96330202J2710390\n" +
            "SUL35644750079505\n" +
            "WV2ZZZ70ZXH107701\n" +
            "JT172SC1100190079\n" +
            "ХТН00661410535327\n" +
            "ХТН006614К0576292\n" +
            "330200С0661982 Х96330202С2465827\n" +
            "VF1HJD40X64945703\n" +
            "JT121LK1800003985\n" +
            "0023659\n" +
            "623644\n" +
            "VF6MFF4DE48787317\n" +
            "0843468\n" +
            "VF1FLBCB64Y057612\n" +
            "0395114\n" +
            "0152338\n" +
            "WDB9340321L143711\n" +
            "Ж11ПТ2919\n" +
            "WMA06XZZ6DP043847\n" +
            "WSM00000003274601\n" +
            "WV2ZZZ7HZ9H129029\n" +
            "V2ZZZ70ZRH088610\n" +
            "WV1ZZZ7HZ4H103223\n" +
            "WV2ZZZ70ZXH048664\n" +
            "MMBCNK7402D016589\n" +
            "WV1ZZZ7HZ8H046637\n" +
            "YV3R9K8267A117926\n" +
            "10093414\n" +
            "MMBJNKL40NH081955\n";
}
