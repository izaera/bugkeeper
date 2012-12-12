package tk.bugkeeper.server.app;

import java.util.Arrays;
import java.util.List;

import tk.bugkeeper.server.model.dao.EntityManager;
import tk.bugkeeper.server.model.entity.impl.User;

import com.google.inject.Inject;

public class BugKeeperServerImpl implements BugKeeperServer {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static final List<Class<?>> entityClasses = (List)Arrays.asList(
			User.class
	);

	private EntityManager entityManager;

	@Inject
	public BugKeeperServerImpl( EntityManager entityManager ){
		this.entityManager = entityManager;
	}

	@Override
	public void start() {
		entityManager.createDatastore(entityClasses);
	}
	
	@Override
	public void stop() {
		
	}
}
