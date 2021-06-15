package javatasks.classes.maintask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomValues {
    private static final String[] names = {"Иван", "Петр", "Игорь", "Сергей", "Михаил", "Максим", "Анатолей",
            "Андрей", "Василий", "Станислав", "Владимир", "Павел", "Антон", "Николай", "Константин"};
    private static final String[] surnames = {"Иванов", "Петров", "Сидоров", "Марков", "Пушкин", "Вершинин",
            "Жуков", "Островский", "Зайцев", "Волков", "Толстой", "Антонов", "Сафонов", "Ходьков", "Николаев"};
    private static final String[] patronymic = {"Анатольевич", "Иванович", "Петрович", "Павлович", "Валерьевич",
            "Игоревич", "Владимирович", "Олегович", "Дмитриевич", "Васильевич", "Артемович", "Станиславович", "Эдуардович"};
    private static final String[] dobs = {"15.11.1989", "13.09.1988", "05.12.1983", "23.07.1986", "03.04.1982",
            "21.06.1997", "30.12.2000", "16.02.2001", "02.01.1990", "17.08.2005", "24.09.2003", "07.01.2004", "10.10.1993"};
    private static final String[] addresses = {"г.Минск, ул.Подрезковская, 58", "г.Гомель, ул.Бабаевская, 80/96",
            "г.Жлобин, ул.Внуковская, 63-281", "г.Брест, ул.Петропавловский 1-й пер, 13", "г.Речица, ул.Бибиревская, 99-241",
            "г.Гродно, ул.Молодежная, 6-206", "г.Красногорское, ул.Жерновская, 92", "г.Могилев, ул. Мужества, дом 75",
            "г.Славгород, ул.Коцюбинского, 45-270", "г.Витебск, ул.Красноармейская 7-я, 11"};
    private static final String[] phones = {"12345", "23456", "34567", "45678", "56789", "67890", "13579", "24680", "123321",
            "222222", "787687", "564738", "989878", "897867", "555666", "678987"};

    private static final Random rnd = new Random();

    public static String getRandomName() {
        int i = rnd.nextInt(names.length);
        return names[i];
    }

    public static String getRandomSurname() {
        int i = rnd.nextInt(surnames.length);
        return surnames[i];
    }

    public static String getRandomPatronymic() {
        int i = rnd.nextInt(patronymic.length);
        return patronymic[i];
    }

    public static Date getRandomDob() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        int i = rnd.nextInt(dobs.length);
        return sdf.parse(dobs[i]);
    }

    public static String getRandomAddress() {
        int i = rnd.nextInt(addresses.length);
        return addresses[i];
    }

    public static String getRandomPhones() {
        int i = rnd.nextInt(phones.length);
        return phones[i];
    }
}
