package com.mpavlik.todos.service;

import com.mpavlik.todos.model.Task;
import com.mpavlik.todos.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TaskRepository repository;


    @Override
    public Task createTask(Task task){
        return repository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {

        return repository.findAll();
        // Sort in controller most likely
        // sort tasks by date either in backend or front end
        // sort.by method isn't working in this class, fix later
    }

    public void deleteTask(int id){
        repository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return repository.save(task);
    }
}
