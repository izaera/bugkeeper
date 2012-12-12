package tk.bugkeeper.client.ui.view.login;

import tk.bugkeeper.client.ui.View;
import tk.bugkeeper.client.ui.view.login.LoginView.Presenter;

public interface LoginView extends View<Presenter> {

	public interface Presenter {
		void login();
	}

	String getUser();
	String getPassword();
	void showMessage(String message);
	
}
