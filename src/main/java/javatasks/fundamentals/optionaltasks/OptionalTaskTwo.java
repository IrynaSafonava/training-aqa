package javatasks.fundamentals.optionaltasks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OptionalTaskTwo {

    // TODO 4. Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array's size: ");
        int arrSize = sc.nextInt();

        System.out.print("Enter a value M for the interval [-M, M]: ");
        int Max = sc.nextInt();
        int Min = -Max;

        Random rnd = new Random();
        int[][] arrayInitial = new int[arrSize][arrSize];
        System.out.println("An array randomly filled is: ");

        for (int i = 0; i < arrayInitial.length; i++) {
            for (int j = 0; j < arrayInitial[i].length; j++) {
                arrayInitial[i][j] = rnd.nextInt((Max + 1) - Min) + Min;
                System.out.printf("%6d", arrayInitial[i][j]);
            }
            System.out.println();
        }

        int maxNum = 0;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        for (int i = 0; i < arrayInitial.length; i++) {
            for (int j = 0; j < arrayInitial[i].length; j++) {
                if (maxNum <= arrayInitial[i][j]) {
                    maxNum = arrayInitial[i][j];
                }
            }
        }

        for (int i = 0; i < arrayInitial.length; i++) {
            for (int j = 0; j < arrayInitial[i].length; j++) {
                if (arrayInitial[i][j] == maxNum) {
                    if (!rows.contains(i)) {
                        rows.add(i);
                    }
                    if (!columns.contains(j)) {
                        columns.add(j);
                    }
                }
            }
        }

        System.out.println("Max number in the array: " + maxNum);
        System.out.println("Rows to delete " + rows.toString());
        System.out.println("Columns to delete " + columns.toString());
        System.out.println("An array after rework is: ");

        int[][] arrayReworked = new int[arrSize - rows.size()][arrSize - columns.size()];

        for (int i = 0, m = 0; i < arrayInitial.length; i++) {
            if (!rows.contains(i)) {
                for (int j = 0, n = 0; j < arrayInitial[i].length; j++) {
                    if (!columns.contains(j)) {
                        arrayReworked[m][n] = arrayInitial[i][j];
                        System.out.printf("%6d", arrayReworked[m][n]);
                        n++;
                    }
                }
                System.out.println();
                m++;
            }
        }
    }
}
