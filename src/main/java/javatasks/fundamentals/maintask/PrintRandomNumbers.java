package javatasks.fundamentals.maintask;

// TODO 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

public class PrintRandomNumbers {
    public static void randomPrint () {
        int[] array = ArrayFiller.randomArrayFiller();
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
