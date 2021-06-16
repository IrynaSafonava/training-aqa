package javatasks.javacollections.maintask;

import javatasks.classes.maintask.Menu;

import java.util.Scanner;

/**
 * Звукозапись. Определить иерархию музыкальных композиций. Записать на диск сборку. Подсчитать продолжительность.
 * Провести перестановку композиций диска на основе принадлежности к стилю. Найти композицию, соответствующую заданному
 * диапазону длины треков.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome! \n");
        Scanner scanner = new Scanner(System.in);

        Menu.printMenu();
        int action = Menu.askFurtherAction(scanner);

        while (action >= 0) {
            switch (action) {
                case 0:
                    System.out.println("Closing the programme. Bye-Bye!");
                    action = -1;
                    break;
                case 1:

                    action = Menu.askFurtherAction(scanner);
                    break;
                default:
                    System.out.println("Only [0-6] acceptable");
                    action = Menu.askFurtherAction(scanner);
                    break;
            }
        }
    }
}
