package com.tts.FinalProjectCruiseApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.FinalProjectCruiseApp.Model.Task;
import com.tts.FinalProjectCruiseApp.Repositories.TaskRepo;

@Controller
public class TaskController {

	@Autowired
	public TaskRepo taskRepo;

////// Go to Pages - Get Methods

	// GoTo Index page
	@GetMapping(value = "/")
	public String index(Task task, Model model) {
		model.addAttribute("tasks", taskRepo.findAll());
		return "index";
	}

	// GoTo Create On-Boat Task page
	@GetMapping(value = "/onboard")
	public String createOnBoardTask(Task task) {
		return "createTaskPageA";
	}

	// GoTo Create Off-Boat Task page
	@GetMapping(value = "/offboard")
	public String createOffBoardTask(Task task) {
		return "createTaskPageB";
	}

////// post new on-board task to showPage

	@PostMapping("/onboard")
	public String submitOnBoardTask(Task task, Model model) {
		model.addAttribute("id", task.getId());
		model.addAttribute("title", task.getTitle());
		model.addAttribute("description", task.getDescription());
		model.addAttribute("createdBy", task.getCreator());
		model.addAttribute("date", task.getDate());
		model.addAttribute("importance", task.getImportance());

		taskRepo.save(task);
		model.addAttribute("onTasks", taskRepo.findAll());
		return "showPage";
	}

////// post new off-board task to showPage

	@PostMapping("/offboard")
	public String submitOffBoardTask(Task task, Model model) {
		model.addAttribute("id", task.getId());
		model.addAttribute("title", task.getTitle());
		model.addAttribute("description", task.getDescription());
		model.addAttribute("createdBy", task.getCreator());
		model.addAttribute("date", task.getDate());
		model.addAttribute("importance", task.getImportance());

		taskRepo.save(task);
		model.addAttribute("offTasks", taskRepo.findAll());
		return "showPage";
	}

////// DELETE BUTTON

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletePostWithId(@PathVariable Long id, Task task, Model model) {
		model.addAttribute("tasks", taskRepo.findAll());
		taskRepo.deleteById(id);
		return "showPage";
	}
////// UPDATE GET/PUT

	// EDIT - Go To Page
	@GetMapping("/edit/{id}")
	public String getEditPage(@PathVariable Long id, Task task1, Model model) {
		Task task = taskRepo.findById(id).orElse(null);
		model.addAttribute("tasks", task);
		return "edit";
	}

	// EDIT a specific blog on edit page
	@PutMapping("/edit/{id}")
	public String editPost(@PathVariable Long id, Task task, Model model) {
		Task task1 = taskRepo.findById(id).orElse(null);

		task1.setTitle(task1.getTitle());
		task1.setDescription(task1.getDescription());
		task1.setCreator(task1.getCreator());
		task1.setDate(task1.getDate());
		task1.setImportance(task1.getImportance());
		taskRepo.save(task);

		model.addAttribute("onTasks", taskRepo.findAll());
		return "showPage";
	}

}// endClass