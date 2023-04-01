package army.image_vin;

public class UpperCaseUtil {
    private static final String str = "26-87С9\n" +
            "26-88С9\n" +
            "26-90С9\n" +
            "26-91С9\n";

    public static void main(String[] args) {
        System.out.println(str.replace("-", "").replace(" ", ""));
    }
}
