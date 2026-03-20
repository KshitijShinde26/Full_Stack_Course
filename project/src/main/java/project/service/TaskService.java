package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Task;
import project.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    // ✅ GET ALL
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    // ✅ ADD (DB INSERT)
    public void addTask(Task task) {
        task.setStatus("PENDING");
        repo.save(task);   // 🔥 SAVES TO DB
    }

    // ✅ DELETE (DB DELETE)
    public void deleteTask(Long id) {
        repo.deleteById(id);   // 🔥 DELETE FROM DB
    }

    // ✅ COMPLETE (DB UPDATE)
    public void markCompleted(Long id) {
        Task task = repo.findById(id).orElse(null);

        if (task != null) {
            task.setStatus("COMPLETED");
            repo.save(task);   // 🔥 UPDATE DB
        }
    }

    // ✅ GET BY ID
    public Task getTaskById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ UPDATE (VERY IMPORTANT FIX)
    public void updateTask(Task updatedTask) {

        Task existing = repo.findById(updatedTask.getId()).orElse(null);

        if (existing != null) {
            existing.setTitle(updatedTask.getTitle());
            existing.setDescription(updatedTask.getDescription());
            existing.setPriority(updatedTask.getPriority());
            existing.setStatus(updatedTask.getStatus());
            existing.setDueDate(updatedTask.getDueDate());

            repo.save(existing);
        }
    }
}