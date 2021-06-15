package javatasks.fundamentals.maintask;

//TODO 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class BackOrder {

    public static void backOrder(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}
