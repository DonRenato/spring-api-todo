package com.accademia.demo.controller;

import com.accademia.demo.entity.ToDo;
import com.accademia.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDo> create(@RequestBody ToDo todo) {
        ToDo saved = toDoService.createToDo(todo);

        return ResponseEntity.status(201).body(saved);

    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAll() {
        return ResponseEntity.ok(toDoService.getAll());
    }

    @GetMapping("/{toDoId}")
    public ResponseEntity<ToDo> getById(@PathVariable int toDoId) {
        return ResponseEntity.ok(toDoService.getById(toDoId));
    }

    @PutMapping("/{toDoId}")
    public ResponseEntity<ToDo> update(@PathVariable int toDoId, @RequestBody ToDo status) {
       return ResponseEntity.ok(toDoService.updateToDo(toDoId, status));


    }

    @GetMapping("/tasks")
    public ResponseEntity<List<ToDo>> getAllTodoDone(@RequestParam("done") boolean status) {
        return  ResponseEntity.ok(toDoService.getAllDone(status));
    }
}
