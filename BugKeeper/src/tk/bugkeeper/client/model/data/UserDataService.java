package tk.bugkeeper.client.model.data;

import tk.bugkeeper.client.model.proxy.UserProxy;

import com.google.web.bindery.requestfactory.shared.Receiver;

public interface UserDataService extends DataService<UserProxy> {
	
	public enum LoginResult {
		OK, BAD_USER_OR_PASSWORD
	}

	void login( String user, String password, Receiver<LoginResult> receiver );

}
