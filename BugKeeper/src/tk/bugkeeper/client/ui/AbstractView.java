package tk.bugkeeper.client.ui;

import com.google.gwt.user.client.ui.Composite;

public abstract class AbstractView<PRESENTER_TYPE> extends Composite implements View<PRESENTER_TYPE> {

	protected PRESENTER_TYPE presenter;

	@Override
	public final void setPresenter(PRESENTER_TYPE presenter) {
		this.presenter = presenter;
	}

}
