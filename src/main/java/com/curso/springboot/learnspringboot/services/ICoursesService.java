package com.curso.springboot.learnspringboot.services;

import com.curso.springboot.learnspringboot.models.Course;
import com.curso.springboot.learnspringboot.models.Todo;

import java.time.LocalDate;
import java.util.List;


public interface ICoursesService {

    public List<Course> getAllCourses();

}
