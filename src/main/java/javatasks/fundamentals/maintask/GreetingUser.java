package javatasks.fundamentals.maintask;

//TODO 1. Приветствовать любого пользователя при вводе его имени через командную строку.

public class GreetingUser {

    public static void helloUser (String[] args) {
        String name = args[0];
        System.out.println("Hello, " + name);
    }

}
