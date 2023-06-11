package com.example.springwebexercise.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(Long id){
        super("Could not find teacher with id: " + id);
    }
}
