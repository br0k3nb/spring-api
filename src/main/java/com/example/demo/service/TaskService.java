package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task save(Task task) {
        task.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task findTaskById(String id) {
        return repository.findById(id).get();
    }

    public Task updateTask(Task task) {
        Task taskToUpdate =  repository.findById(task.getId()).get();
        taskToUpdate.setEmployee(task.getEmployee());
        taskToUpdate.setDescription(task.getDescription());

        return repository.save(taskToUpdate);
    }

    public String deleteTaskById(String id) {
       repository.deleteById(id);
       return "The task with id " + id + " was deleted!";
    }

}
