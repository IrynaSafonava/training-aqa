package javatasks.classes.maintask;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/* TODO Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
    Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные
    на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
        1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
        Создать массив объектов. Вывести:
        a) список студентов заданного факультета;
        b) списки студентов для каждого факультета и курса;
        c) список студентов, родившихся после заданного года;
        d) список учебной группы.*/

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Welcome to our UNIVERSITY! \n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Before we start, please input the number of students you'd like to enroll: ");

        while (!scanner.hasNextInt()) {
            System.out.print("That is not an integer! Please try again: ");
            scanner.next();
        }
        int numberOfStudents = scanner.nextInt();
        ArrayList<Student> students = Student.createListOfRandomStudents(numberOfStudents);

        Menu.printMenu();
        int action = Menu.askFurtherAction(scanner);

        while (action >= 0) {
            switch (action) {
                case 0:
                    System.out.println("Closing the programme. Bye-Bye!");
                    action = -1;
                    break;
                case 1:
                    Student.showListOfAllStudents(students);
                    action = Menu.askFurtherAction(scanner);
                    break;
                case 2:
                    System.out.print("Please input the group name to show the list of students in it: ");
                    String group = scanner.next();
                    Student.listOfStudentsInGroup(group, students);
                    action = Menu.askFurtherAction(scanner);
                    break;
                case 3:
                    System.out.print("Please input a year to show the list of students born after required year: ");
                    String year = scanner.next();
                    Student.listOfStudentsBornAfterSelectedYear(year, students);
                    action = Menu.askFurtherAction(scanner);
                    break;
                case 4:
                    System.out.print("Please input a faculty abbreviation to show the list of students: ");
                    String facAbbr = scanner.next();
                    Student.listOfStudentsByFaculty(facAbbr, students);
                    action = Menu.askFurtherAction(scanner);
                    break;
                case 5:
                    System.out.print("Please input a faculty abbreviation: ");
                    String facAbr = scanner.next();
                    System.out.print("Please input a faculty course: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("That is not an integer! Please try again: ");
                        scanner.next();
                    }
                    int course = scanner.nextInt();
                    Student.listOfStudentsByFacultyAndCourse(facAbr, course, students);
                    action = Menu.askFurtherAction(scanner);
                    break;
                case 6:
                    Menu.printMenu();
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
