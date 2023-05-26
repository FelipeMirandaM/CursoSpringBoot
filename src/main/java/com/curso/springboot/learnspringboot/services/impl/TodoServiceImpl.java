package com.curso.springboot.learnspringboot.services.impl;

import com.curso.springboot.learnspringboot.models.Todo;
import com.curso.springboot.learnspringboot.repositories.TodoRepository;
import com.curso.springboot.learnspringboot.services.ICoursesService;
import com.curso.springboot.learnspringboot.services.ITodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoServiceImpl implements ITodoService {

    private TodoRepository todoRepository;
    private static int todosCount = 0;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

        Todo todo = new Todo(todosCount++, username, description, targetDate, done);
        todoRepository.save(todo);

    }

    @Override
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findById(int id) {


        return todoRepository.findById(id).get();
    }

    @Override
    public void updateTodo(Todo todo) {
       todoRepository.save(todo);
    }

    @Override
    public List<Todo> findByUsername(String username) {

        return todoRepository.findByusername(username);
    }


}
