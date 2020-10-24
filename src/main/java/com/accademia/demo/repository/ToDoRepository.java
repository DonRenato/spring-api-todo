package com.accademia.demo.repository;

import com.accademia.demo.entity.ToDo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Integer> {


    List<ToDo> findAllByDone(boolean status);

}
