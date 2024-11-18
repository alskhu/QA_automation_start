package org.example.Student2;

/**
 * Создайте класс Student с полями для хранения имени и ID студента.
 * В классе StudentManager используйте ArrayList<Student> для хранения списка студентов.
 * Реализуйте методы для добавления нового студента в список, удаления студента по ID и получения списка всех студентов.
 */

public class Main {
    public static void main(String[] args) {
        //если система такая, что id не меняется после создания студента
        Student student1 = new Student();
        Student student2 = new Student("Ivan", "001");
        Student student3 = new Student("Kirill");

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        StudentManager studentManager = new StudentManager();
        studentManager.addStudents(student1);
        studentManager.addStudents(student2);
        studentManager.addStudents(student3);

        studentManager.removeStudent(student3.getId());

        System.out.println(studentManager.getStudents());


    }
}
