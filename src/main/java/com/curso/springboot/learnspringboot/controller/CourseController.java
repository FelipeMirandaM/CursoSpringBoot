package com.curso.springboot.learnspringboot.controller;

import com.curso.springboot.learnspringboot.entity.Course;
import com.curso.springboot.learnspringboot.service.impl.CoursesServicesImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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
