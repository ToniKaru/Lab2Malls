package se.iths.toni.webservices;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MongoDbMallRepository implements MallRepository{

    private final MongoDbConfig mongoDbConfig;
    
    private final MongoClient mongoClient;


    public MongoDbMallRepository(MongoDbConfig mongoDbConfig, 
                                 MongoClient mongoClient) {
        this.mongoDbConfig = mongoDbConfig;
        this.mongoClient = mongoClient;
    }

    @Override
    public List<Mall> getList() {
        return getCollection().find().into(new ArrayList<>());
    }

    @Override
    @NonNull
    public void save(Mall mall) {
        getCollection().insertOne(mall);
    }
    
    @NonNull
    private MongoCollection<Mall> getCollection() {
        return mongoClient.getDatabase(mongoDbConfig.getName())
            .getCollection(mongoDbConfig.getCollection(), Mall.class);
    }
}
