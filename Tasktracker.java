package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@RestController
@RequestMapping("api/v1/task")
public class Tasktracker {
    ArrayList<Task> Tasks = new ArrayList<>();

    @GetMapping
    public ArrayList<Task> getTask() {
        return Tasks;


    }

    @PostMapping("/display")
    public String addTask(@RequestBody Task task) {
        Tasks.add(task);
        return "task disply!";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task) {
        Tasks.set(index, task);
        return "task update";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        Tasks.remove(index);
        return "task delete";

    }
    @PutMapping("/status/{index}")
    public String status(@PathVariable int index) {
        Tasks.get(index);
        Task task1 = Tasks.get(index);
        task1.setStatus("done");
        Tasks.set(index,task1);
        return "status changed";



    }
@PostMapping("/search/{index}")
    public String search(@PathVariable int index, Task task) {
        if (Tasks.equals("ID")) {
            System.out.println(Tasks);
        }
        return "task Search";

    }
}
