package golden.key;

/*
    Mike invited Mary to play a game: they take from pack two balls at random. Two of them are white, one is black.
    If balls of one colour - wins Mary, if they are different - wins Mike.
    Are rules fair ?
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Part_two_3 {
    private static int countOfWhite = 0;

    public static void main(String[] args) {
        Part_two_3 part_two_3 = new Part_two_3();
        List<Ball> balls =  part_two_3.getListWithTwoWhiteAndOneBlackBall();
        int numberOfTrials = 1000;
        Random random = new Random();
        for (int i = 0; i < numberOfTrials; i++) {
            takeTwoBalls(balls, random);
            checkBalls(balls);
            resetBalls(balls);
        }
        double probability = countOfWhite / (double) numberOfTrials;
        System.out.println(probability);
        System.out.println("Rules are not fair. Mike will win more times " + probability);
    }

    private static void resetBalls(List<Ball> balls) {
        balls.forEach(b -> b.setTaken(false));
    }

    private static void checkBalls(List<Ball> balls) {
        List<Ball> notTakenBall = balls.stream().filter(e -> !e.getTaken()).collect(Collectors.toList());
        if(notTakenBall.get(0).getColour().equals(Colour.WHITE)){
            countOfWhite++;
        }
    }

    private static void takeTwoBalls(List<Ball> balls, Random random) {
        Ball ballOne = getRandomNotTakenBall(balls, random);
        ballOne.setTaken(true);
        Ball ballTwo = getRandomNotTakenBall(balls, random);
        ballTwo.setTaken(true);
    }

    private static Ball getRandomNotTakenBall(List<Ball> balls, Random random) {
        List<Ball> notTakenBalls = balls.stream().filter(ball -> !ball.getTaken()).collect(Collectors.toList());
        int randomIndexOfNotTaken = random.nextInt(notTakenBalls.size());
        return notTakenBalls.get(randomIndexOfNotTaken);
    }

    private  List<Ball> getListWithTwoWhiteAndOneBlackBall() {
        Ball whiteBallOne = new Ball(Colour.WHITE, false);
        Ball whiteBallTwo = new Ball(Colour.WHITE, false);
        Ball blackBall = new Ball(Colour.BLACK, false);
        return Arrays.asList(whiteBallOne, whiteBallTwo, blackBall);
    }

    private class Ball{
        Colour colour;
        Boolean taken;

        public Ball(Colour colour, Boolean taken) {
            this.colour = colour;
            this.taken = taken;
        }

        public Colour getColour() {
            return colour;
        }

        public void setColour(Colour colour) {
            this.colour = colour;
        }

        public Boolean getTaken() {
            return taken;
        }

        public void setTaken(Boolean taken) {
            this.taken = taken;
        }
    }

    enum Colour{
        WHITE,
        BLACK
    }
}
