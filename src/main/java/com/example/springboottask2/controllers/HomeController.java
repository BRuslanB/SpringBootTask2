package com.example.springboottask2.controllers;

import com.example.springboottask2.db.DBManager;
import com.example.springboottask2.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String index(Model model){
        ArrayList<Student> students = DBManager.getAllStudents();
        model.addAttribute("all_students", students);
        return "index";
    }

    @GetMapping(value = "/add_student")
    public String addItem(Model model){
        return "addStudent";
    }

    @PostMapping(value = "/add_student")
    public String addItem (@RequestParam(name = "student_name") String name,
                           @RequestParam(name = "student_surname") String surname,
                           @RequestParam(name = "student_exam") int exam){

        String mark = "F";
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        if (exam >= 90) {
            mark = "A";
            } else if (exam >= 75 && exam <= 89) {
                mark = "B";
            } else if (exam >= 60 && exam <= 74) {
                mark = "C";
            } else if (exam >= 50 && exam <= 59) {
                mark = "D";
        }
        student.setMark(mark);

        DBManager.addStudent(student);

        return "redirect:/";
    }

    @GetMapping(value = "/details/{studentId}")
    public String details(@PathVariable(name="studentId") Long id,
                              Model model){
        Student student = DBManager.getStudent(id);
        model.addAttribute("one_student", student);
        return "details";
    }
}