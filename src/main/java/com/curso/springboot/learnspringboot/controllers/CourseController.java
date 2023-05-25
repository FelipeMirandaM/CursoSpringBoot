package com.curso.springboot.learnspringboot.controllers;

import com.curso.springboot.learnspringboot.models.Course;
import com.curso.springboot.learnspringboot.services.impl.CoursesServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private CoursesServiceImpl coursesServices;

    public CourseController(CoursesServiceImpl coursesServices) {
        this.coursesServices = coursesServices;
    }

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return coursesServices.getAllCourses();
    }

}
