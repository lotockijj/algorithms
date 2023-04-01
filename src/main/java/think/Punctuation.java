package think;

/*
A message has been encoded as a text stream that is to be read character by character. The stream contains
a series of comma-delimited integers, each a positive number capable of being represented by a C++ int.
However, the character represented by a particular integer depends on the current decoding mode. There are
three modes: uppercase, lowercase, and punctuation.
In uppercase mode, each integer represents an uppercase letter: The integer modulo 27 indicates the letter
of the alphabet (where 1 = A and so on). So an input value of 143 in uppercase mode would yield the letter
H because 143 modulo 27 is 8 and H is the eighth letter in the alphabet.
The lowercase mode works the same but with lowercase letters; the remainder of dividing the integer by 27
represents the lowercase letter (1 = a and so on). So an input value of 56 in lowercase mode would yield the
letter b because 57 modulo 27 is 2 and b is the second letter in the alphabet.
In punctuation mode, the integer is instead considered modulo 9, with the interpretation given by Table 2-3
below. So 19 would yield an exclamation point because 19 modulo 9 is 1.
At the beginning of each message, the decoding mode is uppercase letters. Each time the modulo operation
(by 27 or 9, depending on mode) results in 0, the decoding mode switches. If the current mode is
uppercase, the mode switches to lowercase letters. If the current mode is lowercase, the mode switches to
punctuation, and if it is punctuation, it switches back to uppercase.
 */

import java.util.HashMap;
import java.util.Map;

public class Punctuation {
    private static String decodedMassage = "18,12312,171,763,98423,1208,216,11,500,18,241,0,32,20620,27,10";
    private static Map<Integer, String> punctuations = initializePunctuation();

    enum modes{
        UPPERCASE, LOWERCASE, PUNCTUATION
    }

    public static void main(String[] args) {
        modes mode = modes.UPPERCASE;
        String[] splitDecodedMassege = decodedMassage.split(",");
        for (int i = 0; i < splitDecodedMassege.length; i++) {
            int tempIntCharacter = 0;
            if(mode == modes.UPPERCASE || mode == modes.LOWERCASE){
               tempIntCharacter = Integer.parseInt(splitDecodedMassege[i])%27;
            }
            if(mode == modes.PUNCTUATION){
                tempIntCharacter = Integer.parseInt(splitDecodedMassege[i])%9;
            }
            if(tempIntCharacter == 0){
                mode = changeMode(mode);
                continue;
            }
            String result = String.valueOf((char)(tempIntCharacter + 96)).toUpperCase();
            if(mode == modes.UPPERCASE){
                result = result.toUpperCase();
            }
            if(mode == modes.LOWERCASE){
                result = result.toLowerCase();
            }
            if(mode == modes.PUNCTUATION){
                result = punctuations.get(tempIntCharacter);
            }
            System.out.print(result);
        }
    }

    private static modes changeMode(modes mode) {
        modes tempMode = null;
        if(mode == modes.UPPERCASE){
            tempMode = modes.LOWERCASE;
        }
        if(mode == modes.LOWERCASE){
            tempMode = modes.PUNCTUATION;
        }
        if(mode == modes.PUNCTUATION){
            tempMode = modes.UPPERCASE;
        }
        return tempMode;
    }

    private static Map<Integer, String> initializePunctuation() {
        Map<Integer, String> punctuations = new HashMap<>();
        punctuations.put(1, "!");
        punctuations.put(2, "?");
        punctuations.put(3, ",");
        punctuations.put(4, ".");
        punctuations.put(5, " ");
        punctuations.put(6, ";");
        punctuations.put(7, "\"");
        punctuations.put(8, "'");
        return punctuations;
    }
}
