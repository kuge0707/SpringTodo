package com.example.spring_todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring_todo.domains.Task;
import com.example.spring_todo.mappers.TaskMapper;

@Controller
public class TaskController {
	private final TaskMapper taskMapper;
	
	@Autowired
	public TaskController(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Task> tasks = taskMapper.all();
		model.addAttribute("tasks", tasks);
		return "index";
	}	
	
	@GetMapping("/addtask")
	public String addTask() {
		return "add_task";
	}
	
	@PostMapping("/addtask")
	public String addTaskExe(@RequestParam("title") String title, @RequestParam("deadline") String deadline) {
		Task task = new Task(title, deadline);
		taskMapper.add(task);
		return "redirect:/";
	}
	
	@PostMapping("/change-state")
	public String changeState(@RequestParam("task_id") int id) {
		taskMapper.change(id);
		return "redirect:/";
	}

}
