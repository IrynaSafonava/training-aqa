package javatasks.javacollections.maintask;

import java.util.Scanner;

public class ServiceMenu {
    public static void printMenu() {
        System.out.println("Please choose an action: \n" +
                "1 - Burn tracks to a disk \n" +
                "2 - Count total duration \n" +
                "3 - Play tracks by genre \n" +
                "4 - Show track(s) according to requirements \n" +
                "0 - Exit \n" +
                "and press ENTER to submit \n");
    }

    public static int askFurtherAction(Scanner sc) {
        int number;
        do {
            System.out.println("Choose [1-4] to continue or [0] to exit.");
            while (!sc.hasNextInt()) {
                System.out.println("Input is not correct. Positive integer required. " +
                        "Please choose [1-4] to continue or [0] to exit");
                sc.next();
            }
            number = sc.nextInt();
        } while (number < 0);
        return number;
    }
}
