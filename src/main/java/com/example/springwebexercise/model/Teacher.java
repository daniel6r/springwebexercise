package com.example.springwebexercise.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher {
    private Long id;
    @NotBlank(message = "First name can not be blank")
    private String firstName;
    @NotBlank(message = "Last name can not be blank")
    private String lastName;
    @Size(min = 1, message = "At least {min} course is required")
    private List<String> courses;
    private boolean active;

    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, List<String> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
        this.active = true;
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

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
