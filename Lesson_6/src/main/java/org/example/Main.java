package org.example;

import org.example.task_1.Student;
import org.example.task_2.PhoneBook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        //Создаем коллекцию, содержащую объекты класса Student
        Set<Student> students = new HashSet<>();
        students.add(new Student("Иван", "Группа 13", 1, List.of(1, 3, 4, 5, 5)));
        students.add(new Student("Ирина", "Группа 13", 1, List.of(2, 3, 3, 5, 1)));
        students.add(new Student("Денис", "Группа 7", 1, List.of(1, 3, 4, 3, 5)));
        students.add(new Student("Василий", "Группа 6", 1, List.of(2, 3, 2, 1, 1)));

        //Печатаем всех студентов обучающихся на 1 курсе
        printStudents(students, 1);

        //Удаляем студентов со средним баллом меньше 3
        removeLowGradeStudents(students);

        //Переводим студентов на следующий курс, если средний балл >= 3
        moveUpGradeStudents(students);

        //Печатаем всех студентов обучающихся на 1 курсе после удаления и перевода
        printStudents(students, 1);

        //Печатаем всех студентов обучающихся на 2 курсе
        printStudents(students, 2);

        //Задание 2
        //Создаем коллекцию
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Федоров", "89123456787");
        phoneBook.add("Матвеев", "89323453489");
        phoneBook.add("Сидорова", "89323453439");
        phoneBook.add("Иванов", "89867230481");
        phoneBook.add("Петрова", "87459163459");
        phoneBook.add("Петрова", "89346832789");

        //Выводим номера телефонов по фамилиям
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петрова"));
        System.out.println(phoneBook.get("Сидоров"));
    }

    //Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе
    public static void printStudents(Set<Student> students, int course) {
        int count = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                student.printInfo();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("На " + course + " курсе нет студентов");
        }
        System.out.println();
    }

    //Метод для удаления студентов с низким средним баллом ( менее 3 )
    public static void removeLowGradeStudents(Set<Student> students) {
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if (student.getAverageGrade() < 3) {
                itr.remove();
            }
        }
    }

    //Метод, который переводит студента на следующий курс, если средний балл >= 3
    public static void moveUpGradeStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.moveToNextCourse();
            }
        }
    }
}