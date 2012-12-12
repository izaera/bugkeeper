package tk.bugkeeper.client.ui.activity.login;

import tk.bugkeeper.client.model.data.UserDataService;
import tk.bugkeeper.client.model.data.UserDataService.LoginResult;
import tk.bugkeeper.client.ui.AbstractActivity;
import tk.bugkeeper.client.ui.activity.home.HomePlace;
import tk.bugkeeper.client.ui.view.login.LoginView;
import tk.bugkeeper.client.ui.view.login.LoginView.Presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class LoginActivity extends AbstractActivity<LoginPlace,LoginView> implements Presenter {

	private UserDataService userDataService;

	@Inject
	public LoginActivity(final LoginView view, final PlaceController placeController, final UserDataService userDataService ) {
		super(view, placeController);
		this.userDataService = userDataService;
	}

	@Override
	protected void start(EventBus eventBus) {
	}

	@Override
	public void login() {
		final LoginView view = getView();
		userDataService.login( view.getUser(), view.getPassword(), new Receiver<LoginResult>() {
			@Override
			public void onSuccess(LoginResult result) {
				switch( result ) {
					case OK: {
						getPlaceController().goTo( new HomePlace() );
						break;
					}
					case BAD_USER_OR_PASSWORD: {
						view.showMessage( "Usuario o contraseña no válidos" );
						break;
					}
				}
			}
		});
	}


}
