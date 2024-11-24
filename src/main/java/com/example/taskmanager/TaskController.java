package com.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/task")
    public String createTask(@RequestBody Task task) {
        String sql = "INSERT INTO task(id, name, description, priority, status) VALUES (:taskId, :taskName, :taskDescription, :taskPriority, :taskStatus)";

        Map<String, Object> map = new HashMap<>();
        map.put("taskId", task.getId());
        map.put("taskName", task.getName());
        map.put("taskDescription", task.getDescription());
        map.put("taskPriority", task.getPriority());
        map.put("taskStatus", task.getStatus());

        namedParameterJdbcTemplate.update(sql, map);

        return "<h1>Created Task!</h1>";
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable int id) {
        String sql = "SELECT id, name, description, priority, status " +
                "FROM task WHERE id = :taskId";
        Map<String, Object> map = new HashMap<>();
        map.put("taskId", id);

        List<Task> taskList = namedParameterJdbcTemplate.query(sql, map, new TaskRowMapper());

        if (!taskList.isEmpty()) {
            return taskList.getFirst();
        } else {
            return null;
        }
    }

    @GetMapping("/tasks")
    public List tasks() {
        String sql = "SELECT * " +
                "FROM task";
        Map<String, Object> map = new HashMap<>();

        List<Task> taskList = namedParameterJdbcTemplate.query(sql, map, new TaskRowMapper());

        if (!taskList.isEmpty()) {
            return taskList;
        } else {
            return null;
        }
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
