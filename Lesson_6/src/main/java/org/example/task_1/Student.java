package org.example.task_1;

import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        double sum = 0;

        for (int grade : grades) {
            sum += grade;
        }
        return grades.isEmpty() ? 0 : sum / grades.size();
    }

    public void moveToNextCourse() {
        this.course++;
    }

    public void printInfo() {
        System.out.println("Имя студента: " + this.name + " курс: " + this.course);
    }

    public int getCourse() {
        return course;
    }
}
