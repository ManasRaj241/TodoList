package com.manas.springboot.mywebapp.todo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todosCount = 0;

	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++todosCount, "Manas", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Raj", "Learn DevOps", LocalDate.now().plusMonths(3), false));
		todos.add(new Todo(++todosCount, "Sameer", "Learn Hibernate", LocalDate.now().plusMonths(6), false));
		todos.add(new Todo(++todosCount, "Rakesh", "Learn Django", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(++todosCount, "Subham", "Learn Java", LocalDate.now().plusMonths(1), false));
	}

	public List<Todo> findByUsername(String username) {
 		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		//todo.getId() == id
		//todo -> todo.getid() == id
 		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
 		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
 		//We are getting all the todos with stream method, then we filter the acquired result with our predicate/ condition, we are returning the first match
 		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
