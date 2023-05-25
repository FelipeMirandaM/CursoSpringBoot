package com.curso.springboot.learnspringboot.services;

import com.curso.springboot.learnspringboot.models.Todo;

import java.time.LocalDate;
import java.util.List;

public interface ITodoService {


    public List<Todo> findAll();

    public void addTodo(String username, String description, LocalDate targetDate, boolean done);

    public void deleteById(int id);

    public Todo findById(int id);

    public void updateTodo(Todo todo);
}
