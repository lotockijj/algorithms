package golden.key;

/* What is the biggest amount of sticks with the size 1 dm which is needed for creation of rectangle with an area 64 power2 dm */

public class Kee_4_5_12 {
    public static void main(String[] args) {
        int biggestAmount = 0;
        int maxAmount = 64;
        for (int i = 1; i < maxAmount; i++) {
            if(maxAmount % i == 0){
                int tempBiggestAmount = 2*(maxAmount / i + i);
                System.out.print(tempBiggestAmount + ":" + maxAmount/i + ":" + i + ",  ");
                biggestAmount = biggestAmount < tempBiggestAmount ? tempBiggestAmount : biggestAmount;
            }
        }
        System.out.println("\n" + biggestAmount);
        double cinemaPrice = 11;
        double diskPrice = 20;
        double chipsPrice = 3.5;
        double busPrice = 0.75;
        double amountOfMoney = 32;
        System.out.println((cinemaPrice + diskPrice + chipsPrice) > amountOfMoney);
        System.out.println((cinemaPrice + diskPrice + busPrice) <= amountOfMoney);
        System.out.println((2*cinemaPrice + busPrice + busPrice) >= amountOfMoney);
    }
}
