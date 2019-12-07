package edu.ifrs.poa.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.poa.example.entity.Todo;
import edu.ifrs.poa.example.repository.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController{

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }    

    @GetMapping
    public List<Todo> list(){
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Todo listDetail(@PathVariable("id") Long id) {
        return todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Não encontrado."));
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable("id") Long id, @RequestBody Todo todo){
        todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Não encontrado."));
        return todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        todoRepository.deleteById(id);
    }
}