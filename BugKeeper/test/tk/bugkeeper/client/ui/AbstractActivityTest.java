package tk.bugkeeper.client.ui;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AbstractActivityTest {

	@SuppressWarnings("unchecked")
	private final View<AbstractActivity<?,?>> view = mock( View.class );
	private final PlaceController placeController = mock( PlaceController.class );
	private final AcceptsOneWidget panel = mock( AcceptsOneWidget.class );
	private final EventBus eventBus = mock(EventBus.class);
	private final AbstractActivity<Place, View<?>> activity = new AbstractActivity<Place, View<?>>( view, placeController ) {
		@Override
		protected void start(EventBus eventBus) {
		}
	};

	@Test
	public void testConstructorSetsViewPresenter() {
		// Setup
		
		// Test

		// Check
		verify(view).setPresenter(activity);
	}
	
	@Test
	public void testStartSetsPanelWidget() {
		// Setup
		
		// Test
		activity.start(panel, eventBus);
		
		// Check
		verify(panel).setWidget( view );
	}

	@Test
	public void testStartResetsView() {
		// Setup
		
		// Test
		activity.start(panel, eventBus);
		
		// Check
		verify(view).reset();
	}
}
