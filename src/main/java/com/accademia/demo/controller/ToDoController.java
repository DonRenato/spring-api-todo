package com.accademia.demo.controller;

import com.accademia.demo.entity.ToDo;
import com.accademia.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ToDo> getAll() {
        return (ResponseEntity) ResponseEntity.ok(toDoService.getAll());
    }

    @GetMapping("/{toDoId}")
    public ResponseEntity<ToDo> getById(@PathVariable int toDoId) {
        return ResponseEntity.ok(toDoService.getById(toDoId));
    }

    @PutMapping("/{toDoId}")
    public ResponseEntity<ToDo> update(@PathVariable int toDoId, @RequestBody boolean status) {
       return ResponseEntity.ok(toDoService.updateToDo(toDoId, status));


    }

    @GetMapping("/{status}")
    public ResponseEntity<ToDo> getAllTodoDone(@PathVariable boolean status) {
        return (ResponseEntity) ResponseEntity.ok(toDoService.getAllDone(status));
    }
}
