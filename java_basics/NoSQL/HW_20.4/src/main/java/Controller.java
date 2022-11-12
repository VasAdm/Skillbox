import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import support.DBConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller extends DBConnector {
    private static MongoCollection<Document> shops;
    private static MongoCollection<Document> goods;
    private static final UpdateOptions options = new UpdateOptions().upsert(true);


    public Controller() {
        super();
        shops = db.getCollection("Shops");
        goods = db.getCollection("Goods");
    }

    public void addShop(String name) {
        if (!isAlreadyExist(shops, name)) {
            Document shop = new Document();
            shop.append("name", name);
            shop.append("goods", new ArrayList<String>());
            shops.insertOne(shop);
        } else System.out.println("Такой магазин уже есть");

    }

    public void addGood(String name, String price) {
        if (!isAlreadyExist(goods, name)) {
            Document good = new Document();
            good.append("name", name);
            good.append("price", Double.parseDouble(price));
            goods.insertOne(good);
        } else System.out.println("Такой товар уже есть");
    }

    public void putGoodToShop(String good, String shop) {
        boolean isShopExist = isAlreadyExist(shops, shop);
        boolean isGoodExist = isAlreadyExist(goods, good);

        Bson filter = Filters.eq("name", shop);
        Bson match = Aggregates.match(filter);

        Bson filterGoods = Aggregates.match(Filters.eq("goods", good));

        List<Bson> pipeline = Arrays.asList(match, filterGoods);

        boolean isShopContains = shops.aggregate(pipeline).iterator().hasNext();

        if (isGoodExist && isShopExist && !isShopContains) {
            Bson filterGood = Filters.eq("name", good);
            Document tmpGood = goods.find(filterGood).first();
            Bson update = Updates.push("goods", tmpGood);
            shops.findOneAndUpdate(filter, update);
        } else System.out.println("В магазине уже есть такой товар");
    }

    public void goodsStat() {
        Bson unwindGoods = Aggregates.unwind("$goods");
        String groupIdCast = "$name";

        BsonField sumField = Accumulators.sum("Колличество товаров в магазине", 1);
        BsonField avgField = Accumulators.avg("Средняя стоимость товаров", "$goods.price");
        BsonField maxField = Accumulators.max("Самый дорогой товар", "$goods.price");
        BsonField minField = Accumulators.min("Самый дешовый товар", "$goods.price");

        Bson qwe = BsonDocument.parse("{$cond : { if : {$lt : ['$goods.price', 100]}, then:1, else:0}}");
        BsonField lessThenHundred = Accumulators.sum("Кол-во товаров дешевле 100руб", qwe);

        Bson fields = Aggregates.group(groupIdCast, List.of(sumField, avgField, maxField, minField, lessThenHundred));

        Facet sumFacet = new Facet("statistic", unwindGoods, fields);

        Bson facetStage = Aggregates.facet(sumFacet);

        List<Bson> pipeline = new ArrayList<>(List.of(facetStage));

        JsonWriterSettings settings = JsonWriterSettings.builder()
                .indent(true)
                .outputMode(JsonMode.SHELL)
                .build();

        shops.aggregate(pipeline).forEach(s -> System.out.println(s.toJson(settings)));

    }

    public boolean isAlreadyExist(MongoCollection<Document> collection, String name) {
        return collection.find(new Document("name", name)).iterator().hasNext();
    }
}


//Пример: СТАТИСТИКА_ТОВАРОВ
//
//        Команда должна выводить для каждого магазина:
//
//        общее количество наименований товаров,
//        среднюю цену товаров,
//        самый дорогой и самый дешевый товар,
//        количество товаров дешевле 100 рублей.