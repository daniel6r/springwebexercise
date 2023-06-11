package com.example.springwebexercise.controller;

import com.example.springwebexercise.model.Teacher;
import com.example.springwebexercise.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(@RequestParam(required = false) List<String> course){
        return teacherService.getTeachers(course);
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacher(@PathVariable("id") Long id){
        return teacherService.getTeacher(id);
    }

    @PostMapping("teachers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }
}
