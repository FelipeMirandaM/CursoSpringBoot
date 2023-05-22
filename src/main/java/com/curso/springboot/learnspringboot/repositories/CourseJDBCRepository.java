package com.curso.springboot.learnspringboot.repositories;

import com.curso.springboot.learnspringboot.models.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {


    private JdbcTemplate springJdbcTemplate;

    public CourseJDBCRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    private static String INSERT_QUERY=
            """
                            insert into course(id,name,author)
                                    values(?,?,?)
                    """;

    private static String DELETE_QUERY=
            """
                            delete from course where id = ?
                    """;

    private static String SELECT_QUERY=
            """
                            select * from course where id = ?
                    """;
    public void insert(Course course){

        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(),course.getName(),course.getAuthor());

    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(long id){
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),id);
    }
}
