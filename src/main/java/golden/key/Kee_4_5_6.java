package golden.key;

/* In the competition 90 children take part.Everyone has number from 10 to 99 including.
   Company "Ping-Pong" gave prizes to owners whose numbers could be divided on every number in their note.
   How many children received prizes ?
 */

public class Kee_4_5_6 {
    public static void main(String[] args) {
        int countOfNumbers = 0;
        for (int i = 10; i <= 99; i++) {
            String str = String.valueOf(i);
            String[] arr = str.split("");
            int firstNumber = Integer.valueOf(arr[0]);
            int secondNumber = Integer.valueOf(arr[1]);
            if(i % firstNumber == 0){
                if(secondNumber != 0 && i % secondNumber == 0){
                    countOfNumbers++;
                }
            }
        }
        System.out.println(countOfNumbers);
    }
}
