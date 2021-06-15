package javatasks.fundamentals.maintask;

// TODO 4.Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
//  и вывести результат на консоль.

import java.util.Arrays;

public class ForthTask {
    public static void calculate(String[] args){
        int sum = 0;
        int prod = 1;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
            prod *= Integer.parseInt(arg);
        }
        System.out.println("For " + Arrays.toString(args) + " sum: " + sum + ", prod: " + prod);
    }
}
