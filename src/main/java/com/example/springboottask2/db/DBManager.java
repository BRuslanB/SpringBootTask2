package com.example.springboottask2.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 5L;

    static {
        students.add(new Student(1L, "Serik", "Erikov", 91, "A"));
        students.add(new Student(2L, "Patrick", "Zuckerberg", 100, "A"));
        students.add(new Student(3L, "Sabina", "Assetova", 33, "F"));
        students.add(new Student(4L, "Madina", "Adletova", 77, "B"));
    }

    public static ArrayList<Student> getAllStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student getStudent(Long id){
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }
}