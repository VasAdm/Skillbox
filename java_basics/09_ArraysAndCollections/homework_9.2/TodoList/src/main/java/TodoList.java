import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> todoS = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoS.add(todo);
        System.out.println("Добавлено дело: " + "\"" + todo + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (checkIndexNum(index)) {
            todoS.add(index,todo);
            System.out.println("Дело: " + "\"" + todo + "\"" + " добавлено на " + index + "-ю позицию");
        } else todoS.add(todo);
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (checkIndexNum(index)) {
            String temp = todoS.get(index);
            todoS.set(index, todo);
            System.out.println("Дело \"" + temp + "\" заменено на \"" + todo + "\"");
        } else System.out.println("Такого индекса не существует");
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (todoS.size() - 1 >= index && index >= 0){
            System.out.println("Дело \"" + todoS.get(index) + "\" удалено.");
            todoS.remove(index);
        } else System.out.println("Невозможно удалить не существующий индекс");
    }

    public boolean checkIndexNum(int index) {
        return !(todoS.size() < index);
    }

    public ArrayList<String> getTodos() {
        for (int i = 0; i < todoS.size(); i++) System.out.println(i + " - " + todoS.get(i));
        return todoS;
    }
}