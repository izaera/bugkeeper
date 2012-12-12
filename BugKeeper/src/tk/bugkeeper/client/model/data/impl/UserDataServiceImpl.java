package tk.bugkeeper.client.model.data.impl;

import tk.bugkeeper.client.model.data.UserDataService;
import tk.bugkeeper.client.model.data.impl.request.BugKeeperRequestFactory;
import tk.bugkeeper.client.model.data.impl.request.UserDataServiceRequest;
import tk.bugkeeper.client.model.proxy.UserProxy;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class UserDataServiceImpl extends AbstractDataService<UserDataServiceRequest,UserProxy> implements UserDataService {

	@Inject
	public UserDataServiceImpl( BugKeeperRequestFactory requestFactory ) {
		super(requestFactory);
	}

	@Override
	protected UserDataServiceRequest newRequest() {
		return requestFactory.userDataServiceRequest();
	}

	@Override
	public void login(String user, String password, Receiver<LoginResult> receiver) {
		consumeRequest().login(user, password).fire(receiver);
	}

	
}
