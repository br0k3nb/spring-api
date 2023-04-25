package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Task createTask(@RequestBody Task task) {
        return service.save(task);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Task> getTasks() {
        return service.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return service.findTaskById(id);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        return service.deleteTaskById(id);
    }

}
