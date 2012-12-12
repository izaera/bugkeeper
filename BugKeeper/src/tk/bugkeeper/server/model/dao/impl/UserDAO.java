package tk.bugkeeper.server.model.dao.impl;

import tk.bugkeeper.client.model.data.UserDataService.LoginResult;
import tk.bugkeeper.server.model.dao.AbstractDAO;
import tk.bugkeeper.server.model.dao.EntityManager;
import tk.bugkeeper.server.model.entity.impl.User;

import com.google.inject.Inject;

public class UserDAO extends AbstractDAO<User> {
	
	@Inject
	public UserDAO(EntityManager entityManager) {
		super(entityManager,User.class);
	}
	
	public LoginResult login( String user, String password ) {
		User dbUser = entityManager.findByUniqueField( User.class, "user", user );
		if( dbUser!=null && dbUser.getPassword().equals(password) ) {
			return LoginResult.OK;
		} else {
			return LoginResult.BAD_USER_OR_PASSWORD;
		}
	}
}
