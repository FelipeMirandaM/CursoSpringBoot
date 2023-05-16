package com.curso.springboot.learnspringboot.repository;

import com.curso.springboot.learnspringboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringJPARepository extends JpaRepository<Course,Long> {

}
