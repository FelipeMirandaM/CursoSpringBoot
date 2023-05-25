package com.curso.springboot.learnspringboot.services.impl;

import com.curso.springboot.learnspringboot.models.Todo;
import com.curso.springboot.learnspringboot.services.ICoursesService;
import com.curso.springboot.learnspringboot.services.ITodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoServiceImpl implements ITodoService {

    private static List<Todo> todos= new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(todosCount++, "in28minutes", "learn aws", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "in28minutes", "learn gcp", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "in28minutes", "learn spring", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "in28minutes", "learn DevOps", LocalDate.now().plusYears(1), false));
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

        Todo todo = new Todo(todosCount++, username, description, targetDate, done);
        todos.add(todo);

    }

    @Override
    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() ==id;
        todos.removeIf(predicate);
    }

    @Override
    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() ==id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    @Override
    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }


}
