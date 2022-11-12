package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/tasks/")
    public List<Task> list() {
        return new ArrayList<>((Collection<? extends Task>) repository.findAll());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Task> optionalTask = repository.findById(id);

        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PostMapping("/tasks/")
    public int add(Task task) {
        task.setCreationDate(LocalDateTime.now());
        Task newTask = repository.save(task);
        return newTask.getId();
    }

    @DeleteMapping("/tasks/")
    public ResponseEntity<?> clear() {
        repository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> del(@PathVariable int id) {
        Optional<Task> optionalTask = repository.findById(id);

        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> put(@PathVariable int id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(add(task));
        }
        Task tmpTask = optionalTask.get();
        tmpTask.setText(task.getText());
        tmpTask.setTaskDate(task.getTaskDate().toString());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(repository.save(tmpTask));

    }
}
