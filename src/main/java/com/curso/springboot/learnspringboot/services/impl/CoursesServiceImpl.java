package com.curso.springboot.learnspringboot.services.impl;


import com.curso.springboot.learnspringboot.models.Course;
import com.curso.springboot.learnspringboot.services.ICoursesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements ICoursesService {
    @Override
    public List<Course> getAllCourses() {
        List<Course> listCourses = new ArrayList<>();
        listCourses.add(new Course(1, "Learn AWS", "in28minutes"));
        listCourses.add(new Course(2, "Learn DevOps", "in28minutes"));
        listCourses.add(new Course(3, "Learn Azure", "in28minutes"));
        listCourses.add(new Course(4, "Learn GCP", "in28minutes"));
        return listCourses;

    }
}
