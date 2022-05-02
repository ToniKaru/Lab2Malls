package se.iths.toni.webservices;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.naming.Named;

@ConfigurationProperties("db")
public interface MongoDbConfig extends Named {
    
    @NonNull
    String getCollection();
}
