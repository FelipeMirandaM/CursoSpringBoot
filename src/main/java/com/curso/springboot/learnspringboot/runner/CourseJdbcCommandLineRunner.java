package com.curso.springboot.learnspringboot.runner;

import com.curso.springboot.learnspringboot.entity.Course;
import com.curso.springboot.learnspringboot.repository.CourseJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJDBCRepository repository;


    @Override
    public void run(String... args) throws Exception {

        repository.insert(new Course(1, "test1", "testAuthor1"));
        repository.insert(new Course(2, "test2", "testAuthor2"));
        repository.insert(new Course(3, "test3", "testAuthor3"));

        repository.deleteById(2);

        System.out.println(repository.findById(1));

    }
}
