package com.curso.springboot.learnspringboot.controllers;

import com.curso.springboot.learnspringboot.models.Todo;
import com.curso.springboot.learnspringboot.services.impl.TodoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoServiceImpl todoService;


    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        model.addAttribute("todos", todoService.findByUsername(getLoggedinUsername()));

        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model) {
        Todo todo = new Todo(0, getLoggedinUsername(), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);

        return "addTodo";

    }

    @PostMapping("add-todo")
    public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodo";
        }

        todoService.addTodo(getLoggedinUsername(), todo.getDescription(), todo.getTargetDate(), false);
        model.addAttribute("todos", todoService.findAll());
        return "redirect:list-todos";

    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);

        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "updateTodo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "updateTodo";
        }
        todo.setUsername(getLoggedinUsername());
        todoService.updateTodo(todo);

        model.addAttribute("todos", todoService.findAll());
        return "redirect:list-todos";

    }

    private String getLoggedinUsername() {
        return SecurityContextHolder
                .getContext().getAuthentication().getName();
    }


}
