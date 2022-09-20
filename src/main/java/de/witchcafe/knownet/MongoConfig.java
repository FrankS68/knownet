package de.witchcafe.knownet;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import de.witchcafe.base.StatusController;
import de.witchcafe.base.StatusController.Status;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
	@Autowired
	StatusController statusController; 
	
    @Override
    protected String getDatabaseName() {
        return "test";
    }
 
    @Override
    public MongoClient mongoClient() {
    	String 
    	// mongoUser = "fse418";
    	mongoUser = System.getenv("mongoUser");
		String // mongoPwd = "zimt706zicke";
		mongoPwd = System.getenv("mongoPwd");
		String mongoServer = "cluster0.crvlg4r.mongodb.net";
		String mongoDb = "testy";
		return mongoClient(mongoUser,mongoPwd,mongoServer,mongoDb);
    }
    
    public MongoClient mongoClient(String mongoUser,String mongoPwd,String mongoServer,String mongoDb) {
        ConnectionString connectionString = new ConnectionString(String.format("mongodb+srv://%s:%s@%s/%s",mongoUser,mongoPwd,mongoServer,mongoDb));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        MongoClient client = null;
        try {
        	client = MongoClients.create(mongoClientSettings);
        	statusController.log(
        			getClass().getCanonicalName(), 
        			Status.error, 
        			String.format("created mongo client for server %s opening database %s",mongoServer,mongoDb));
        }
        catch (Exception exc) {
        	statusController.log(
        			getClass().getCanonicalName(), 
        			Status.error, 
        			String.format("error %s when connecting to server %s opening database %s",exc.getMessage(), mongoServer,mongoDb));
        	throw exc;
        }
		return client;
    }
 
    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("de.witchcafe");
    }
}