package org.example.Student2;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudents(Student students) {
        this.students.add(students);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void removeStudent(String id) {
        //вариант 1: найти студента по id и удалить

        Student targetStudent = null;

        for (Student student: students) {
            if (student.getId().equals(id)) {
                targetStudent = student;
            }
        }

        if (targetStudent!=null) {
            students.remove(targetStudent);
        } else {
            System.out.println("Student with id " + id + " not found");
        }
    }
}
