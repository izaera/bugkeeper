package tk.bugkeeper.client.ui.activity.login;

import com.google.gwt.place.shared.*;

/**
 * Represents the serialized state of an activity
 * @author Ivan
 *
 */
public final class LoginPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		@Override
		public LoginPlace getPlace(final String token) {
			LoginPlace place = new LoginPlace();
			return place;
		}

		@Override
		public String getToken(final LoginPlace place) {
			return "";
		}
	}

	public LoginPlace() {
	}

	@Override
	public int hashCode() {
		return getClass().getName().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if( other==null ) return false;
		return other.getClass()==getClass();
	}
}
