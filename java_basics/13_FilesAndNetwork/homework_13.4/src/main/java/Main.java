public class Main {
    private static final String sourcePath = "https://lenta.ru/";
    private static final String directoryPath = "images/";

    public static void main(String[] args) {
//        ImagesParser.parseImages(sourcePath, directoryPath);
        PagesParser.parsePage("https://skillbox.ru/courses/");
    }

}
