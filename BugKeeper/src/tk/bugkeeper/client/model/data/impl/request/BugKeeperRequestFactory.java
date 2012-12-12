package tk.bugkeeper.client.model.data.impl.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface BugKeeperRequestFactory extends RequestFactory {
	UserDataServiceRequest userDataServiceRequest();
}
