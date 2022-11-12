import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Parser extends RecursiveAction {
    private final Page page;

    public Parser(Page page) {
        this.page = page;
        page.linkCollector();
    }

    @Override
    protected void compute() {
        List<Parser> taskList = new ArrayList<>();
        for (Page child : page.getChildren()) {
            Parser task = new Parser(child);
            task.fork();
            taskList.add(task);
        }

        for (Parser task : taskList) {
            task.join();
        }
    }

}