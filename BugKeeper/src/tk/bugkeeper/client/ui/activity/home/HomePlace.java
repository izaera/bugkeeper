package tk.bugkeeper.client.ui.activity.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		@Override
		public HomePlace getPlace(final String token) {
			HomePlace place = new HomePlace();
			return place;
		}

		@Override
		public String getToken(final HomePlace place) {
			return "";
		}
	}

	public HomePlace() {
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
