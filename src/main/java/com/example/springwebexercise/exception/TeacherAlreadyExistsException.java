package com.example.springwebexercise.exception;

public class TeacherAlreadyExistsException extends RuntimeException{
    public TeacherAlreadyExistsException(String firstName, String lastName){
        super("Teacher " + firstName + " " + lastName + " already exists");
    }
}
