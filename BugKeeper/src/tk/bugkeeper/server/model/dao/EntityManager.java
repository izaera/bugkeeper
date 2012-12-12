package tk.bugkeeper.server.model.dao;

import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tk.bugkeeper.server.model.entity.AbstractEntity;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mongodb.Mongo;

public class EntityManager {
	
	private Log log = LogFactory.getLog(EntityManager.class);

	private Mongo mongo;
    private Datastore ds;
    private Morphia morphia;
	private String database;
    
    @Inject
    public EntityManager(
		@Named("tk.bugkeeper.datastore.dao.EntityManager.host") String host, 
		@Named("tk.bugkeeper.datastore.dao.EntityManager.port") int port, 
		@Named("tk.bugkeeper.datastore.dao.EntityManager.database") String database 
    ) {
    	try {
			mongo = new Mongo(host,port);
			morphia = new Morphia();
			this.database = database;
		} catch (UnknownHostException e) {
			log.fatal("ctor - cannot connect to mongodb", e);
			throw new RuntimeException("Cannot connect to mongodb",e);
		}
    }
    
    public void createDatastore(List<Class<?>> entityClasses) {
    	for( Class<?> entity : entityClasses ) {
    		morphia.map(entity);
    	}
		ds = morphia.createDatastore(mongo, database);
    }

    public <ENTITY_TYPE extends AbstractEntity> List<ENTITY_TYPE> findAll( final Class<ENTITY_TYPE> entityClass ) {
    	return ds.find(entityClass).asList();
    }

    public <ENTITY_TYPE extends AbstractEntity> ENTITY_TYPE findById( final Class<ENTITY_TYPE> entityClass, final String id ) {
    	return ds.find(entityClass,"id",id).get();
    }

    public <ENTITY_TYPE extends AbstractEntity> ENTITY_TYPE findByUniqueField( final Class<ENTITY_TYPE> entityClass, String field, final String value ) {
    	return ds.find(entityClass,field,value).get();
    }
    
	public void save(final AbstractEntity entity) {
        ds.save(entity);
    }

	public void delete(final AbstractEntity entity) {
		ds.delete(entity);
	}
 
 }