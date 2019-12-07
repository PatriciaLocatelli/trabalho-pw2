package edu.ifrs.poa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifrs.poa.example.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}