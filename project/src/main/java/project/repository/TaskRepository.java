package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // ✅ SEARCH
    List<Task> findByTitleContaining(String keyword);

    // ✅ FILTERS
    List<Task> findByPriority(String priority);
    List<Task> findByStatus(String status);

}