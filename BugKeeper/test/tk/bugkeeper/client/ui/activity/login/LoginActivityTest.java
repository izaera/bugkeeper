package tk.bugkeeper.client.ui.activity.login;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static tk.bugkeeper.client.model.data.test.DataServiceTestSupport.*;

import org.junit.Test;

import tk.bugkeeper.client.model.data.UserDataService;
import tk.bugkeeper.client.model.data.UserDataService.LoginResult;
import tk.bugkeeper.client.ui.activity.home.HomePlace;
import tk.bugkeeper.client.ui.view.login.LoginView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class LoginActivityTest {

	private final LoginView view = mock(LoginView.class);
	private final PlaceController placeController = mock(PlaceController.class);
	private final UserDataService userDataService = mock(UserDataService.class);
	private final LoginActivity act = new LoginActivity( view, placeController, userDataService );

	@SuppressWarnings("unchecked")
	@Test
	public void testLoginCallsServerWithUserAndPasswordObtainedFromView() {
		// Setup
		String user = "pepito";
		String password = "lili";

		when( view.getUser() ).thenReturn( user );
		when( view.getPassword() ).thenReturn( password );
		
		// Test
		act.login();
		
		// Check
		verify( userDataService ).login( eq(user), eq(password), any(Receiver.class) );
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLoginGoesToHomePlaceWhenResultIsOk() {
		// Setup
		returnSuccessWithResult( LoginResult.OK ).when(userDataService).login( any(String.class), any(String.class), any(Receiver.class) );
		
		// Test
		act.login();
		
		// Check
		verify(placeController).goTo( new HomePlace() );
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLoginShowsErrorMessageWhenResultIsBadUserOrPassword() {
		// Setup
		returnSuccessWithResult( LoginResult.BAD_USER_OR_PASSWORD ).when(userDataService).login( any(String.class), any(String.class), any(Receiver.class) );
		
		// Test
		act.login();
		
		// Check
		verify(view).showMessage( any(String.class) );
	}
}
