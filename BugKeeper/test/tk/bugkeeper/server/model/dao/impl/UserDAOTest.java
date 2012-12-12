package tk.bugkeeper.server.model.dao.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import tk.bugkeeper.client.model.data.UserDataService.LoginResult;
import tk.bugkeeper.server.model.dao.EntityManager;
import tk.bugkeeper.server.model.entity.impl.User;

public class UserDAOTest {

	private final EntityManager entityManager = mock(EntityManager.class);
	private final UserDAO dao = new UserDAO(entityManager);

	@Test
	public void testLoginWithValidCredentials() {
		final String user = "pepe";
		final String password = "lili";
		final User dbUser = new User(user, password);
		
		when(entityManager.findByUniqueField( User.class, "user", user )).thenReturn(dbUser);
		
		assertEquals( LoginResult.OK, dao.login(user, password) );
	}

	@Test
	public void testLoginWithInvalidPassword() {
		final String user = "pepe";
		final String password = "lili";
		final String badPassword = "lolo";
		final User dbUser = new User(user, password);
		
		when(entityManager.findByUniqueField( User.class, "user", user )).thenReturn(dbUser);
		
		assertEquals( LoginResult.BAD_USER_OR_PASSWORD, dao.login(user, badPassword) );
	}

	@Test
	public void testLoginWithInvalidUser() {
		final String user = "pepe";
		final String password = "lili";
		
		when(entityManager.findByUniqueField( User.class, "user", user )).thenReturn(null);
		
		assertEquals( LoginResult.BAD_USER_OR_PASSWORD, dao.login(user, password) );
	}

}
