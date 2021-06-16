package javatasks.classes.maintask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Student implements Comparable<Student>{
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Date dob;
    private String address;
    private String phone;
    private Faculty faculty;
    private int course;
    private String group;

    public Student() {
    }

    public Student(int id, String surname, String name, String patronymic, Date dob, String address,
                   String phone, Faculty faculty, int course, String group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Student setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public Student setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Student setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Student setFaculty(Faculty faculty) {
        this.faculty = faculty;
        return this;
    }

    public int getCourse() {
        return course;
    }

    public Student setCourse(int course) {
        this.course = course;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static ArrayList<Student> createListOfRandomStudents(int numberOfStudents) throws ParseException {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new Student());
        }
        int id = 1;
        for (Student student : students) {
            Random rnd = new Random();
            student.setId(id++)
                    .setName(RandomValues.getRandomName())
                    .setSurname(RandomValues.getRandomSurname())
                    .setPatronymic(RandomValues.getRandomPatronymic())
                    .setAddress(RandomValues.getRandomAddress())
                    .setPhone(RandomValues.getRandomPhones())
                    .setDob(RandomValues.getRandomDob())
                    .setFaculty(Faculty.getRandomFaculty(rnd.nextInt(6)))
                    .setCourse(rnd.nextInt(5) + 1)
                    .setGroup(student.faculty.getAbbreviation() + "-" + student.getCourse() + rnd.nextInt(5));
        }
        return students;
    }

    public static void showListOfAllStudents(ArrayList<Student> students) {
        System.out.println("List of students: ");
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void listOfStudentsInGroup(String group, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getGroup().equalsIgnoreCase(group)) {
                System.out.println(student);
            }
        }
    }

    public static void listOfStudentsBornAfterSelectedYear(String year, ArrayList<Student> students) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date dateEntered = sdf.parse(year);
        LocalDate date = dateEntered.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int dateYear = date.getYear();
        for (Student student : students) {
            LocalDate dobStudent = student.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int yearStudent = dobStudent.getYear();
            if (dateYear < yearStudent) {
                System.out.println(student);
            }
        }
    }

    public static void listOfStudentsByFaculty(String facAbbr, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getFaculty().getAbbreviation().equalsIgnoreCase(facAbbr)) {
                System.out.println(student);
            }
        }
    }

    public static void listOfStudentsByFacultyAndCourse(String facAbbr, int course, ArrayList<Student> students) {
        System.out.println("List of students of " + facAbbr + " faculty" + " course #" + course + ":");
        for (Student student : students) {
            if (student.getFaculty().getAbbreviation().equalsIgnoreCase(facAbbr) && student.getCourse() == course) {
                System.out.println(student);
            }
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "{" +
                "ID = " + id +
                ", ФАМИЛИЯ = '" + surname + '\'' +
                ", ИМЯ = '" + name + '\'' +
                ", ОТЧЕСТВО = '" + patronymic + '\'' +
                ", ДАТА РОЖДЕНИЯ = " + sdf.format(dob) +
                ", АДРЕС = " + address +
                ", ТЕЛЕФОН = '" + phone + '\'' +
                ", ФАКУЛЬТЕТ = " + faculty.getName() +
                ", КУРС = " + course +
                ", ГРУППА = '" + group + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int result = this.faculty.compareTo(o.faculty);
        if(result == 0){
            result = this.group.compareTo(o.group);
        }
        return result;
    }
}

