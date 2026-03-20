package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Task;
import project.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        return "index";
    }

 // ADD
    @PostMapping("/add")
    public String addTask(Task task) {
        service.addTask(task);
        return "redirect:/";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "redirect:/";
    }

    // COMPLETE
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        service.markCompleted(id);
        return "redirect:/";
    }

    // UPDATE
    @PostMapping("/update")
    public String updateTask(Task task) {
        service.updateTask(task);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {

        Task task = service.getTaskById(id);

        model.addAttribute("task", task);

        return "edit";   // 👉 must match edit.html
    }
}