package com.example.springboottask2.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    Long id;
    String name;
    String surname;
    int exam;
    String mark;
}
