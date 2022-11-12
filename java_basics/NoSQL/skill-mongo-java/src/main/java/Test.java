import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.*;

public class Test {
    static MongoCollection<Document> collection;

    public static void main(String[] args) {
        String path = "mongo.csv";
        List<String[]> parsedData = ParserCSV.parse(path);

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");

        // Создаем коллекцию
        collection = database.getCollection("SkillboxStudents");

        // Удалим из нее все документы
        collection.drop();

        assert parsedData != null;
        insertData(parsedData);

        //Общее кол-во студентов
        long amountOfStudents = collection.countDocuments();
        System.out.printf("Общее кол-во студентов: %d\n", amountOfStudents);

        //Кол-во студентов старше 40
        BsonDocument ageQuery = BsonDocument.parse("{Age: {$gt: 40}}");
        int OverFortyStudents = (int) collection.countDocuments(ageQuery);
        System.out.printf("Кол-во студентов старше сорока: %d\n", OverFortyStudents);

        //Имя самого молодого студента
        BsonDocument sortByAgeQueryASC = BsonDocument.parse("{Age: 1}");
        String youngestStudentName = Objects.requireNonNull(collection.find().sort(sortByAgeQueryASC).first()).getString("Name");
        System.out.printf("Имя самого молодого студента: %s\n", youngestStudentName);

        //Список курсов самого старого студента
        BsonDocument sortByAgeQueryDESC = BsonDocument.parse("{Age: -1}");
        ArrayList<?> listOfCourses = (ArrayList<?>) Objects.requireNonNull(collection.find().sort(sortByAgeQueryDESC).first()).get("Courses");
        System.out.println("Список курсов самого старого студента:");
        listOfCourses.forEach(a -> System.out.printf(" - %s\n", a));


    }

    public static void insertData(List<String[]> lst) {
        for (String[] str : lst) {
            Document doc = new Document()
                    .append("Name", str[0])
                    .append("Age", Integer.parseInt(str[1]))
                    .append("Courses", Arrays.asList(str[2].split(",")));

            collection.insertOne(doc);
        }
    }
}


//        // Создадим первый документ
//        Document firstDocument = new Document()
//                .append("Type", 1)
//                .append("Description", "Это наш первый документ в MongoDB")
//                .append("Author", "Я")
//                .append("Time", new SimpleDateFormat().format(new Date()));
//
//
//        // Вложенный объект
//        Document nestedObject = new Document()
//                .append("Course", "NoSQL Базы Данных")
//                .append("Author", "Mike Ovchinnikov");
//
//        firstDocument.append("Skillbox", nestedObject);
//
//
//        // Вставляем документ в коллекцию
//        collection.insertOne(firstDocument);
//
//        collection.find().forEach((Consumer<Document>) document -> {
//            System.out.println("Наш первый документ:\n" + document);
//        });
//
//        // Используем JSON-синтаксис для создания объекта
//        Document secondDocument = Document.parse(
//                "{Type: 2, Description:\"Мы создали и нашли этот документ с помощью JSON-синтаксиса\"}"
//        );
//        collection.insertOne(secondDocument);
//
//        // Используем JSON-синтаксис для написания запроса (выбираем документы с Type=2)
//        BsonDocument query = BsonDocument.parse("{Type: {$eq: 2}}");
//        collection.find(query).forEach((Consumer<Document>) document -> {
//            System.out.println("Наш второй документ:\n" + document);
//        });