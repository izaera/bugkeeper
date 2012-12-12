package tk.bugkeeper.datastore;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import tk.bugkeeper.server.model.dao.EntityManager;
import tk.bugkeeper.server.model.dao.impl.UserDAO;
import tk.bugkeeper.server.model.entity.impl.User;


public class DatastoreCreationTest {

	@Ignore
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testCreateRootUserInDB() {
		EntityManager entityManager = new EntityManager("localhost", 27017, "BugKeeper" );
		entityManager.createDatastore( (List)Arrays.asList(User.class) );
		UserDAO dao = new UserDAO(entityManager);
		User user = new User( "00000000-0000-0000-0000-000000000000", "root", "root" );
		dao.save(user);
	}

}
