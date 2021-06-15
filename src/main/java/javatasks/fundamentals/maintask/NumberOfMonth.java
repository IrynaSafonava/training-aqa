package javatasks.fundamentals.maintask;

// TODO 5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
//  Осуществить проверку корректности ввода чисел.

import java.util.Scanner;

public class NumberOfMonth {

    public static void printMonths(String... args) {
        Scanner sc = new Scanner(System.in);
        int m;
        do {
            System.out.print("Please, enter the month's number from 1 to 12: ");
            while (!sc.hasNextInt()) {
                System.out.println("Input is not correct. Please enter from 1 to 12");
                sc.next();
            }
            m = sc.nextInt();
        } while (m > 12 || m < 1);
        switch (m) {
            case 1:
                m = 1;
                System.out.println("January");
                break;
            case 2:
                m = 2;
                System.out.println("February");
                break;
            case 3:
                m = 3;
                System.out.println("March");
                break;
            case 4:
                m = 4;
                System.out.println("April");
                break;
            case 5:
                m = 5;
                System.out.println("May");
                break;
            case 6:
                m = 6;
                System.out.println("June");
                break;
            case 7:
                m = 7;
                System.out.println("July");
                break;
            case 8:
                m = 8;
                System.out.println("August");
                break;
            case 9:
                m = 9;
                System.out.println("September");
                break;
            case 10:
                m = 10;
                System.out.println("October");
                break;
            case 11:
                m = 11;
                System.out.println("November");
                break;
            case 12:
                m = 12;
                System.out.println("December");
                break;
            default:
                System.out.println("Unexpected value: " + m);
        }
    }
}

