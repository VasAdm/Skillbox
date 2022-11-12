package support;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;

public abstract class DBConnector extends Properties {
    protected MongoDatabase db;


    public DBConnector() {
        try {
            String mongoUri = getProperty("mongodb.uri");
            String databaseName = getProperty("mongodb.database");
            db = MongoClients.create(mongoUri).getDatabase(databaseName);
        } catch (IOException e) {
            this.db = null;
        }
    }
}
