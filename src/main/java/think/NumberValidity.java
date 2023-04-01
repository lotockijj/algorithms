package think;

/*The Luhn formula is a widely used system for validating identification numbers. Using the original number,
double the value of every other digit. Then add the values of the individual digits together (if a doubled
value now has two digits, add the digits individually). The identification number is valid if the sum is
divisible by 10.
Write a program that takes an identification number of arbitrary length and determines whether the number
is valid under the Luhn formula. The program must process each character before reading the next one.
 */

public class NumberValidity {

    public static boolean validateNumber(int n, int checkNumber){
        String stringNumber = Integer.toString(n);
        String[] splitStringNumber = stringNumber.split("");
        int result = 0;
        for (int i = 0; i < splitStringNumber.length; i++) {
           if(i %2 == 1){
               int tempResult = Integer.parseInt(splitStringNumber[i]) * 2;
               if(tempResult > 10){
                   String[] split = String.valueOf(tempResult).split("");
                   int tempStringNumber = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
                   result += tempStringNumber;
               } else {
                   result += tempResult;
               }
           } else {
               result += Integer.parseInt(splitStringNumber[i]);
           }
        }
        return result == checkNumber;
    }

    public static void main(String[] args) {
        System.out.println(validateNumber(1762483, 30));
        int n = 18%27;
        System.out.println(n);
    }
}
