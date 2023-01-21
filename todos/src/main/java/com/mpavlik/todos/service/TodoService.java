package com.mpavlik.todos.service;

import com.mpavlik.todos.model.Task;

import java.util.List;

public interface TodoService {
    public Task saveTask(Task task);

    public List<Task> getAllTasks();
}
