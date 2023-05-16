package com.curso.springboot.learnspringboot.runner;

import com.curso.springboot.learnspringboot.entity.Course;
import com.curso.springboot.learnspringboot.repository.CourseJDBCRepository;
import com.curso.springboot.learnspringboot.repository.CourseJPARepository;
import com.curso.springboot.learnspringboot.repository.CourseSpringJPARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {


    private CourseJDBCRepository repositoryJDBC;

    private CourseJPARepository repositoryJPA;

    private CourseSpringJPARepository repositorySpringJPA;

    public CourseCommandLineRunner(CourseJDBCRepository repositoryJDBC, CourseJPARepository repositoryJPA, CourseSpringJPARepository repositorySpringJPA) {
        this.repositoryJDBC = repositoryJDBC;
        this.repositoryJPA = repositoryJPA;
        this.repositorySpringJPA = repositorySpringJPA;
    }

    @Override
    public void run(String... args) throws Exception {

            //runJDBC();
            //runJPA();
            runSpringJpa();

    }

    public void runJDBC(){
        repositoryJDBC.insert(new Course(1, "test1", "testAuthor1"));
        repositoryJDBC.insert(new Course(2, "test2", "testAuthor2"));
        repositoryJDBC.insert(new Course(3, "test3", "testAuthor3"));

        repositoryJDBC.deleteById(2);

        System.out.println(repositoryJDBC.findById(1));

    }

    public void runJPA(){
        repositoryJPA.insert(new Course(1, "testJPA1", "testAuthor1"));
        repositoryJPA.insert(new Course(2, "testJPA2", "testAuthor2"));
        repositoryJPA.insert(new Course(3, "testJPA3", "testAuthor3"));

        repositoryJPA.deleteById(2);

        System.out.println(repositoryJPA.findById(1));
    }

    public void runSpringJpa(){
        repositorySpringJPA.save(new Course(1, "testJPA1", "testAuthor1"));
        repositorySpringJPA.save(new Course(2, "testJPA2", "testAuthor2"));
        repositorySpringJPA.save(new Course(3, "testJPA3", "testAuthor3"));

        repositorySpringJPA.deleteById(2L);

        System.out.println(repositorySpringJPA.findById(1L));
    }
}
