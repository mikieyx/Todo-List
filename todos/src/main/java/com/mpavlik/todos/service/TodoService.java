package com.mpavlik.todos.service;

import com.mpavlik.todos.model.Task;

import java.util.List;


public interface TodoService {
    public Task createTask(Task task);

    public List<Task> getAllTasks();

    public Task updateTask(Task task);

    public void deleteTask(int id);
}
