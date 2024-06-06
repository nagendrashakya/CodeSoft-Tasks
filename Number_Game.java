import java.util.Scanner;
public class Number_Game {

    public static void numberGame() {
        Scanner sc = new Scanner(System.in);

        int number = 1 + (int)(100
                * Math.random());

        int limit = 10;
        int score = 10;
        int i, guess;

        System.out.println("Enter number to guess correct number within 10 attempts");

        for (i = 0; i < limit; i++) {

            System.out.println("Guess the number:");
            guess = sc.nextInt();

            if (number == guess) {
                System.out.println("Congratulations! You guessed the number.");
                System.out.println("your score = " + score);
                break;
            }
            else if (number > guess
                    && i != limit - 1) {
                System.out.println("number is too low");
                score--;
            }
            else if (number < guess
                    && i != limit - 1) {
                System.out.println("Number is too high");
                score--;
            }
            System.out.println("Remaining Attempts : "+ (limit - (i + 1)));
        }

        if (i == limit) {
            System.out.println("Sorry! your attempts ends");
            System.out.println("The number was " + number);
        }
    }

    public static void main(String args[]) {

        numberGame();
    }
}