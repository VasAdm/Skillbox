package main;

import customObjects.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @GetMapping("/tasks/")
    public List<Task> list() {
        return Storage.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Task> optionalTask = Optional.ofNullable(Storage.getTask(id));

        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PostMapping("/tasks/")
    public int add(Task task) {
        return Storage.addTask(task);
    }

    @DeleteMapping("/tasks/")
    public ResponseEntity<?> clear() {
        Storage.deleteAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> del(@PathVariable String id) {
        Optional<Task> optionalTask = Optional.ofNullable(Storage.deleteTask(id));

        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> put(@PathVariable int id, Task task) {
        int code = Storage.putTask(id, task);
        if (code == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else return ResponseEntity.status(HttpStatus.CREATED).body(code);
    }
}
