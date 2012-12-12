package tk.bugkeeper.server.app;

import static org.mockito.Mockito.*;

import org.junit.Test;

import tk.bugkeeper.server.model.dao.EntityManager;

public class BugKeeperServerImplTest {

	@Test
	public void testStartCreatesDatastore() {
		// Setup
		EntityManager entityManager = mock(EntityManager.class);
		BugKeeperServerImpl app = new BugKeeperServerImpl(entityManager);
		
		// Test
		app.start();
		
		// Check
		verify(entityManager).createDatastore( BugKeeperServerImpl.entityClasses );
	}

}
