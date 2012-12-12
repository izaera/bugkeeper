package tk.bugkeeper.client.ui.view.login.impl;

import tk.bugkeeper.client.ui.AbstractView;
import tk.bugkeeper.client.ui.view.login.LoginView;
import tk.bugkeeper.client.ui.view.login.LoginView.Presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

// TODO: cambiar la Grid por FlexTable
public class DefaultLoginView extends AbstractView<Presenter> implements LoginView {

	private static LoginViewImplUiBinder uiBinder = GWT
			.create(LoginViewImplUiBinder.class);

	interface LoginViewImplUiBinder extends UiBinder<Widget, DefaultLoginView> {
	}

	@UiField TextBox userField;
	@UiField PasswordTextBox passwordField;
	@UiField Button enterButton;
	@UiField Label messageLabel;
	
	public DefaultLoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void reset() {
		
	}

	@Override
	public String getUser() {
		return userField.getValue();
	}

	@Override
	public String getPassword() {
		return passwordField.getValue();
	}
	
	@Override
	public void showMessage(String message) {
		messageLabel.setText(message);
	}
	
	@UiHandler("enterButton")
	protected void onEnterButtonClicked( ClickEvent ev ) {
		presenter.login();
	}

}
