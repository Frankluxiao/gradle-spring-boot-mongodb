package crud.spring;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.springframework.stereotype.Component;

@Component
public class DataSourceConfig {

    public Datastore datastore() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("crud.spring.entity");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "employee");
        datastore.ensureIndexes();
        return datastore;
    }


    // Inject an instance of Spring-Boot MongoProperties
//    @Autowired
//    private MongoClient mongoClient;
//
//    @Bean
//    public Datastore datastore(MongoClient mongoClient) {
//        Morphia morphia = new Morphia();
//        // create the Datastore connecting to the default port on the local host
//        final Datastore datastore = morphia().createDatastore(mongoClient, mongoProperties.getDatabase());
//        datastore.ensureIndexes();
//
//        return datastore;
//    }
}