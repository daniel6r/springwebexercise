package com.example.springwebexercise.model;

import java.util.List;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private List<String> courses;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, List<String> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }
}
