package com.ariel.apirest.api_rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ariel.apirest.api_rest.model.Task;
import com.ariel.apirest.api_rest.repository.TaskRepository;

@Component
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task getTaskById(Long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		return optionalTask.get();
	}
	
	public Task updateTaskById(Long id, Task task) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(task.getTitle());
            existingTask.setCompleted(task.isCompleted());
            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("No se encuentra la tarea de id: " + id);
        }
    }
	
	public List<Task> getAllTask(){
		return taskRepository.findAll();
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
