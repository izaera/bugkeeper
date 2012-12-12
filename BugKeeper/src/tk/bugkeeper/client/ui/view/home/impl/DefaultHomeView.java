package tk.bugkeeper.client.ui.view.home.impl;

import tk.bugkeeper.client.ui.AbstractView;
import tk.bugkeeper.client.ui.view.home.HomeView;
import tk.bugkeeper.client.ui.view.home.HomeView.Presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class DefaultHomeView extends AbstractView<Presenter> implements HomeView {

	private static DefaultHomeViewUiBinder uiBinder = GWT
			.create(DefaultHomeViewUiBinder.class);

	interface DefaultHomeViewUiBinder extends UiBinder<Widget, DefaultHomeView> {
	}

	public DefaultHomeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
