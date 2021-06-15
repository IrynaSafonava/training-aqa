package javatasks.fundamentals.maintask;

import java.util.Random;
import java.util.Scanner;

public class ArrayFiller {

    /**
     * Method {@code arrayFiller} requires entering a size of an array {@param int n}
     * and entering each element of an array from a key bord
     *
     * @author Iryna S.
     * @version 0.0.1
     */

    public static int[] arrayFiller() {
        System.out.print("Please entre the number n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter [" + i + "] element: ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    /**
     * Method {@code randomArrayFiller} requires entering a size of an array {@param int n}
     * and then it will be filled be random integers
     *
     * @author Iryna S.
     * @version 0.0.1
     */

    public static int[] randomArrayFiller() {
        System.out.print("Please enter the number of integers: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random ranNum = new Random();
        int[] array = new int[n];
        for (int j = 0; j < array.length; j++) {
            array[j] = ranNum.nextInt();
        }
        return array;
    }
}
