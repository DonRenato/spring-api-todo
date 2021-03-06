package com.accademia.demo.services;

import com.accademia.demo.entity.ToDo;
import com.accademia.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public ToDo updateToDo(int toDoId, ToDo status) {
        return toDoRepository.findById(toDoId).map(t -> {
            t.setDone(status.getDone());
            t.setDescription(status.getDescription());
            return toDoRepository.save(t);
        }).orElseThrow();
    }

    public List<ToDo> getAllDone(boolean status) {
        return toDoRepository.findAllByDone(status);
    }

     public ToDo removeToDo(int toDoId) {
         return toDoRepository.findById(toDoId)
            .map(t -> {
            toDoRepository.delete(t);
            return t;
         }).orElseThrow();

     }

    public String getDescripitionById(int toDoId) {
        return toDoRepository.findById(toDoId).map(t->{
            return t.getDescription();
        }).orElseThrow();


    }
}
