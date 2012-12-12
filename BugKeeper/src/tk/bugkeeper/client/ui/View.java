package tk.bugkeeper.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface View<PRESENTER_TYPE> extends IsWidget {

	void setPresenter( PRESENTER_TYPE presenter );
	void reset();

}
