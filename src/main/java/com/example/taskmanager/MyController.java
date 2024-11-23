package com.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

//    @Autowired
//    @Qualifier("hpPrinter")
//    private Printer printer;

//    @RequestMapping("/test")
//    public String test() {
//        printer.print("Hi!");
//        return "Hello World";
//    }

    @RequestMapping("/tasks")
    public TaskList tasks() {
        int taskId = 0;
        TaskList taskList = new TaskList();
        List<Task> list = new ArrayList<Task>();
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        task1.setId(taskId++);
        task1.setName("Task A");
        task1.setDescription("Cooking");
        task1.setPriority(1);
        task1.setStatus(1);
        task2.setId(taskId++);
        task2.setName("Task B");
        task2.setDescription("Writing");
        task2.setPriority(3);
        task2.setStatus(0);
        task3.setId(taskId++);
        task3.setName("Task C");
        task3.setDescription("Game Development");
        task3.setPriority(2);
        task3.setStatus(0);
        list.add(task1);
        list.add(task2);
        list.add(task3);
        taskList.setTaskList(list);
        return taskList;
    }
}