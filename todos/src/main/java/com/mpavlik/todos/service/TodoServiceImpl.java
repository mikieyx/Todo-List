package com.mpavlik.todos.service;

import com.mpavlik.todos.model.Task;
import com.mpavlik.todos.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TaskRepository repository;

    public void createTask(Task task){
        repository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        Sort sort  = Sort.by(Sort.Direction.ASC, "date");
        return repository.findAll(sort);
    }

    public void deleteTask(int id){
        repository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return repository.save(task);
    }
}
