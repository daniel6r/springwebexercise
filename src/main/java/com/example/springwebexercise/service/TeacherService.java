package com.example.springwebexercise.service;

import com.example.springwebexercise.model.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private List<Teacher> teacherList;

    @PostConstruct
    public void initTeachers(){
        teacherList.add(new Teacher(
                1L, "Tom", "Novak", List.of("Math", "English")
        ));
        teacherList.add(new Teacher(
                1L, "Zack", "Morgan", List.of("Sports", "Philosophy")
        ));
        teacherList.add(new Teacher(
                1L, "Alana", "Novak", List.of("Polish", "English")
        ));
    }

    public List<Teacher> getTeachers(){
        return this.teacherList;
    }

    public Teacher getTeacher(Long id){
        return teacherList.stream().
                filter(teacher -> teacher.getId().equals(id)).
                findFirst().orElse(new Teacher());
    }
}
