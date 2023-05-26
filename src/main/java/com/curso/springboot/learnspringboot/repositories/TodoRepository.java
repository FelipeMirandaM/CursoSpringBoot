package com.curso.springboot.learnspringboot.repositories;

import com.curso.springboot.learnspringboot.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByusername(String userName);
}
