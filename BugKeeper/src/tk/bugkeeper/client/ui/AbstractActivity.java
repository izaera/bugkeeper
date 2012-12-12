package tk.bugkeeper.client.ui;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

@SuppressWarnings("rawtypes")
public abstract class AbstractActivity<PLACE_TYPE extends Place,VIEW_TYPE extends View> implements Activity {

	private final PLACE_TYPE place;
	private final VIEW_TYPE view;
	private final PlaceController placeController;
	
	@SuppressWarnings("unchecked")
	public AbstractActivity(final VIEW_TYPE view, final PlaceController placeController) {
		this.place = (PLACE_TYPE) placeController.getWhere();
		this.view = view;
		this.placeController = placeController;
		view.setPresenter(this);
	}

	@Override
	public final void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.reset();
		panel.setWidget(view);
		start(eventBus);
	}
	
	protected abstract void start(EventBus eventBus);

	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() {
	}

	@Override
	public void onStop() {
	}
	
	protected final PLACE_TYPE getPlace() {
		return place;
	}
	
	protected final VIEW_TYPE getView() {
		return view;
	}
	
	protected final PlaceController getPlaceController() {
		return placeController;
	}

}
