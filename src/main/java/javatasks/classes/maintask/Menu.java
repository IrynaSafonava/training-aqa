package javatasks.classes.maintask;

import java.util.Scanner;

public class Menu {
    public static void printMenu() {
        System.out.println("Please choose an action: \n" +
                "1 - to show the list of all students \n" +
                "2 - to show the list of students in a particular group \n" +
                "3 - to show the list of students born after a particular year \n" +
                "4 - to show the list of students by a faculty \n" +
                "5 - to show the list of students by a faculty and a course \n" +
                "6 - to show the Menu \n" +
                "0 - to exit \n" +
                "and press ENTER to submit \n");
    }

    public static int askFurtherAction(Scanner sc) {
        int number;
        do {
            System.out.println("Choose [1-6] to continue or [0] to exit.");
            while (!sc.hasNextInt()) {
                System.out.println("Input is not correct. Positive integer required. " +
                        "Please choose [1-6] to continue or [0] to exit");
                sc.next();
            }
            number = sc.nextInt();
        } while (number < 0);
        return number;
    }
}
