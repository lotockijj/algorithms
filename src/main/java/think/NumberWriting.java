package think;

public class NumberWriting {

    public static int write(String string){
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            result += (Math.pow(10, string.length() - i - 1))*Character.getNumericValue(string.charAt(i));
        }
        return result;
    }
}
