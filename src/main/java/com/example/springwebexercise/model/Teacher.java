package com.example.springwebexercise.model;

import java.util.List;

public class Teacher {
    private Long id;
    private String firstName;
    private String lastName;
    private List<String> courses;

    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, List<String> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getCourses() {
        return courses;
    }
}
