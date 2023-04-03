package think.one;

/*
Using the same rule as the shapes programs from earlier in the chapter (only
two output statements—one that outputs the hash mark and one that outputs
an end-of-line), write a program that produces the following shape:
########
 ######
  ####
   ##

   2. Or how about:
##
  ####
 ######
########
########
 ######
  ####
   ##
3. Here’s an especially tricky one:
#            #
 ##        ##
  ###    ###
   ########
   ########
  ###    ###
 ##        ##
#            #
*/

public class One {

    public static void main(String[] args) {
        //printRequiredShape();
        //printSecondRequiredShape();
        printThirdRequiredShape();
        for (int i = 0; i < 8; i++) {
            if((i > 0 && i <= 4) || (i >= 4 && i <=6)){
                //System.out.print("#");
            } else {
                //System.out.print("0");48.59 movie !!!
            }
        }
    }

    private static void printThirdRequiredShape() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 14; j++) {
                if(i <= 3   && ((j >= i && j <= i*2)                         || (j > 12 - i*2 && j < 14 - i)) ||
                (i > 3      && ((j >= 8 - i - 1) && (j <= (8 - i - 1)*2)     || j >= i*2 - 1 && j - i <=6))){
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
       System.out.print(stringBuilder);
    }

    private static void printSecondRequiredShape() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0 ;j < 8; j++) {
                if(Math.abs(i - 3.5) + Math.abs(j - 3.5) <= 4)  {
                    stringBuilder.append("#");
                } else{
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void printRequiredShape() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0 ;j < 8; j++) {
                if(i <= j && j < 8 - i)  {
                    stringBuilder.append("#");
                } else{
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
