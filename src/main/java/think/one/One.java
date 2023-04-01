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
*/

import java.util.Set;

public class One {

    public static void main(String[] args) {
        //printRequiredShape();
        printSecondRequiredShape(); //lotockijj-roman@rambler.ru lotockijj-roman@rambler.ru
        Set<Integer> set  = null;
    }
    //git config --global user.email "lotockijj-roman@rambler.ru"


    private static void printSecondRequiredShape() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0 ;j < 8; j++) {
                if(i >= j && j > 8 - i)  {
                    System.out.print("#");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printRequiredShape() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0 ;j < 8; j++) {
                if(i <= j && j < 8 - i)  {
                    System.out.print("#");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
