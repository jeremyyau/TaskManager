package com.example.taskmanager;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @PostMapping("/task")
    public String createTask(@RequestBody Task task) {
        return task.toString();
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable int id) {
        Task task = new Task();
        return task;
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return task;
    }

    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable int id) {
        Task task = new Task();
        return task.toString();
    }
}
