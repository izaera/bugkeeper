package tk.bugkeeper.server.model.entity.impl;

import tk.bugkeeper.server.model.entity.AbstractEntity;

public class User extends AbstractEntity {
	
	private String user;
	private String password;

	public User() {
	}

	public User(String user, String password) {
		init(user,password);
	}

	public User(String id, String user, String password) {
		super(id);
		init(user,password);
	}
	
	private void init(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
