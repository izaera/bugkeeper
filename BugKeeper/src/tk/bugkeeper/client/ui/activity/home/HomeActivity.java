package tk.bugkeeper.client.ui.activity.home;

import tk.bugkeeper.client.ui.AbstractActivity;
import tk.bugkeeper.client.ui.view.home.HomeView;
import tk.bugkeeper.client.ui.view.home.HomeView.Presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public class HomeActivity extends AbstractActivity<HomePlace,HomeView> implements Presenter {

	@Inject
	public HomeActivity(final HomeView view, final PlaceController placeController ) {
		super(view, placeController);
	}

	@Override
	protected void start(EventBus eventBus) {
	}

}
