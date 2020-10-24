package com.accademia.demo.services;

import com.accademia.demo.entity.ToDo;
import com.accademia.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;


    public ToDo createToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public List<ToDo> getAll() {
        return (List<ToDo>) toDoRepository.findAll();
    }

    public ToDo getById(int toDoId) {
        return toDoRepository.findById(toDoId).orElseThrow();
    }

    public ToDo updateToDo(int toDoId, boolean status) {
        var todo = toDoRepository.findById(toDoId);
        todo.map(t -> {
            t.setDone(status);
            return toDoRepository.save(t);
        });


        return null;


    }

    public List<ToDo> getAllDone(boolean status) {
        return toDoRepository.findAllByDone(status);


        }
    }
}
