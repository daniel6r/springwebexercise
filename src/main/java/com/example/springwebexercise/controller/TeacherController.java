package com.example.springwebexercise.controller;

import com.example.springwebexercise.model.Teacher;
import com.example.springwebexercise.service.TeacherService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }


    @GetMapping("teacher/{id}")
    public Teacher getTeacher(@PathVariable("id") Long id){
        return teacherService.getTeacher(id);
    }
}
