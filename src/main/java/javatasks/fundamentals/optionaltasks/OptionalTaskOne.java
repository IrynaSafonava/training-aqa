package javatasks.fundamentals.optionaltasks;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTaskOne {

    public static void main(String[] args) {

        // TODO Задание. Ввести n чисел с консоли.

        Scanner sc = new Scanner(System.in);
        System.out.print("Input array size: ");
        int n = sc.nextInt();
        int i;
        String[] array = new String[n];
        for (i = 0; i < array.length; i++) {
            System.out.print("Insert " + "[" + i + "]" + " element of an array: ");
            array[i] = sc.next();
        }
        System.out.println("Your array is: " + Arrays.toString(array));

        // TODO 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        int maxSize = array[0].length();
        int minSize = array[0].length();

        String maxNum = array[0];
        String minNum = array[0];

        for (i = 0; i < array.length; i++) {
            if (maxSize < array[i].length()) {
                maxNum = array[i];
                maxSize = array[i].length();
            } else if (minSize > array[i].length()) {
                minNum = array[i];
                minSize = array[i].length();
            }
        }
        System.out.println();
        System.out.println("First longest number: " + maxNum);
        System.out.println("First shortest number: " + minNum);
        System.out.println("Length of the longest number: " + maxSize);
        System.out.println("Length of the shortest number: " + minSize);

        // TODO 2.  Вывести числа в порядке возрастания (убывания) значений их длины.

        for (i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));

        // TODO 3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

        int sum = 0;
        for (i = 0; i < array.length; i++) {
            sum += array[i].length();
        }
        double averageSize = (double) sum / array.length;
        System.out.println("Average length of all elements: " + averageSize);

        for (i = 0; i < array.length; i++) {
            if (array[i].length() < averageSize) {
                System.out.println("Element: " + array[i] + ", its length: " + array[i].length());
            }
        }
    }
}
