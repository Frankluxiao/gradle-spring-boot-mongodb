package crud.spring;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DataSourceConfig {

    @Autowired
    private MongoClient mongoClient;

    @Bean
    public Datastore datastore() {

        Morphia morphia = new Morphia();
        morphia.mapPackage("crud.spring.entity");
        Datastore datastore = morphia.createDatastore(mongoClient, "employee");
        datastore.ensureIndexes();

        return datastore;
    }
}