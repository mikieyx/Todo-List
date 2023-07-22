package com.mpavlik.todos.controller;

import com.mpavlik.todos.model.Task;
import com.mpavlik.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoService todoService;


    //    {
//        "completed": false,
//            "dueDate": "2023-01-26",
//            "taskName": "Homework"
//    }post request should be in this form
    @PostMapping("/create")
    public String create(@RequestBody Task task){
        LocalDate date = LocalDate.parse(task.getDueDate().toString(), DateTimeFormatter.ISO_DATE);
        task.setDueDate(date);
        System.out.println(task.getDueDate().toString());
        todoService.createTask(task);
        return "Task created";
    }

    @PostMapping("/update")
    public String update(@RequestBody Task task){
        todoService.updateTask(task);
        return "Task updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        todoService.deleteTask(id);
        return "Task deleted";
    }

    @GetMapping("/getAll")
    public List<Task> getAll(){
        return todoService.getAllTasks();
    }



}
