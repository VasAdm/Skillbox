public class Printer {
    public String queue = "";
    public int pages = 0;
    public int allPages = 0;

    public void append(String text) {append(text, "None", 1);}

    public void append(String text, String name) {append(text, name,1);}

    public void append(String text, String name, int amountOfPages){
        queue = queue + text + " - " + name + " - " + amountOfPages + System.lineSeparator();
        pages = pages + amountOfPages;
    }

    public void clean() {
        queue = "";
        pages = 0;
    }

    public void print() {
        if (queue == "") {
            System.out.println("Очередь пуста.");
        } else {
            System.out.println("В очереди " + getPendingPagesCount() + " страниц");
            System.out.print(queue);
            System.out.println("Печать...");
            allPages = allPages + pages;
            clean();
            System.out.println("В очереди " + getPendingPagesCount() + " страниц");
        }
    }

    public int getPendingPagesCount() {return pages;}

    public int getAllPagesCount(){return allPages;}
}
