package com.curso.springboot.learnspringboot.repositories;

import com.curso.springboot.learnspringboot.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringJPARepository extends JpaRepository<Course,Long> {

        List<Course> findByAuthor(String author);

        List<Course> findByName(String name);

}
