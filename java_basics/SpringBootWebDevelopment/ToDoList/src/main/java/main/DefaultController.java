package main;

import java.util.ArrayList;
import java.util.Collection;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @Autowired
    private TaskRepository repository;

    @RequestMapping("/")
    public String index(Model model) {
        ArrayList<Task> tasks = new ArrayList<>((Collection<? extends Task>) repository.findAll());

        model.addAttribute("tasks", tasks)
                .addAttribute("tasksCount", tasks.size());

        return "index";
    }
}