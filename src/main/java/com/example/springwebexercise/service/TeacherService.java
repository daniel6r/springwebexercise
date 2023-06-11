package com.example.springwebexercise.service;

import com.example.springwebexercise.exception.TeacherAlreadyExistsException;
import com.example.springwebexercise.exception.TeacherNotFoundException;
import com.example.springwebexercise.model.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final List<Teacher> teacherList = new ArrayList<>();

    @Value("${teachers.softdelete}")
    private boolean softDelete;

    @PostConstruct
    public void initTeachers(){
        teacherList.add(new Teacher(
                1L, "Tom", "Novak", List.of("Math", "English")
        ));
        teacherList.add(new Teacher(
                2L, "Zack", "Morgan", List.of("Biology", "Philosophy")
        ));
        teacherList.add(new Teacher(
                3L, "Alana", "Novak", List.of("Polish", "English")
        ));
    }

    public List<Teacher> getTeachers(List<String> course){
        return course != null ? this.teacherList.stream()
                .filter(t -> t.getCourses().containsAll(course))
                .filter(Teacher::isActive)
                .collect(Collectors.toList()) :
                teacherList.stream()
                        .filter(Teacher::isActive)
                        .collect(Collectors.toList());
    }

    public Teacher getTeacher(Long id){
        return teacherList.stream()
                .filter(t -> t.getId().equals(id))
                .filter(Teacher::isActive)
                .findFirst()
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    public void addTeacher(Teacher teacher){
        this.teacherList.stream()
                        .filter(t -> t.getFirstName().equalsIgnoreCase(teacher.getFirstName()))
                        .filter(t -> t.getLastName().equalsIgnoreCase(teacher.getLastName()))
                        .findAny()
                        .ifPresentOrElse(t ->
                                {throw new TeacherAlreadyExistsException(teacher.getFirstName(), teacher.getLastName());},
                                () -> {teacherList.add(teacher);});
    }

    public void updateTeacher(Teacher teacherToUpdate){
        Long id = teacherToUpdate.getId();
        if(!isDuplicate(teacherToUpdate)) {
            teacherList.stream()
                    .filter(t -> t.getId().equals(id))
                    .findAny()
                    .ifPresentOrElse(
                            t -> {
                                t.setFirstName(teacherToUpdate.getFirstName());
                                t.setLastName(teacherToUpdate.getLastName());
                                t.setCourses(teacherToUpdate.getCourses());
                            },
                            () -> {
                                throw new TeacherNotFoundException(id);
                            }
                    );
        } else {
            throw new TeacherAlreadyExistsException(teacherToUpdate.getFirstName(), teacherToUpdate.getLastName());
        }
    }

    private boolean isDuplicate(Teacher teacher){
        return teacherList.stream()
                .filter(t -> t.getFirstName().equalsIgnoreCase(teacher.getFirstName()))
                .filter(t -> t.getLastName().equalsIgnoreCase(teacher.getLastName()))
                .filter(t -> t.getCourses().equals(teacher.getCourses()))
                .findAny()
                .isPresent();
    }

    public void deleteTeacher(Long id){
        teacherList.stream()
                .filter(t -> t.getId().equals(id))
                .findAny()
                .ifPresentOrElse(softDelete ? t -> t.setActive(false) : teacherList::remove,
                        () -> {throw new TeacherNotFoundException(id);});
    }

}
