package com.ariel.apirest.api_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.apirest.api_rest.TaskService;
import com.ariel.apirest.api_rest.model.Task;

@RestController
@RequestMapping("api/task")
@CrossOrigin(origins = "http://localhost:4200") 
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public Task createTak(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@GetMapping
	public List<Task> getAllTask(){
		return taskService.getAllTask();
	}
	
	@GetMapping("{id}")
	public Task searchTaskById(@PathVariable("id") Long id) {
		return taskService.getTaskById(id);
	}
	
	@PutMapping("{id}")
    public Task updateTaskById(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTaskById(id, task);
    }
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id) {
	    taskService.deleteTask(id);
	    return ResponseEntity.noContent().build();
	}
}
