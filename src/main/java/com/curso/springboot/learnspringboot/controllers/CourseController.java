package com.curso.springboot.learnspringboot.controllers;

import com.curso.springboot.learnspringboot.models.Course;
import com.curso.springboot.learnspringboot.services.impl.CoursesServicesImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private CoursesServicesImpl coursesServices;

    public CourseController(CoursesServicesImpl coursesServices) {
        this.coursesServices = coursesServices;
    }

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return coursesServices.getAllCourses();
    }

}
