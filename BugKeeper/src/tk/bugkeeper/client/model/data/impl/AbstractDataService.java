package tk.bugkeeper.client.model.data.impl;


import tk.bugkeeper.client.model.data.*;
import tk.bugkeeper.client.model.data.impl.request.*;

import com.google.web.bindery.requestfactory.shared.*;

abstract class AbstractDataService<REQUEST_TYPE extends RequestContext,PROXY_TYPE extends EntityProxy> implements DataService<PROXY_TYPE> {

	protected BugKeeperRequestFactory requestFactory;
	private REQUEST_TYPE request;
	
	protected AbstractDataService(BugKeeperRequestFactory requestFactory) {
		this.requestFactory = requestFactory;
		this.request = newRequest();
	}

	@Override
	public PROXY_TYPE edit(PROXY_TYPE proxy) {
		return request.edit(proxy);
	}
	
	protected final REQUEST_TYPE consumeRequest() {
		REQUEST_TYPE oldRequest = request;
		request = newRequest();
		return oldRequest;
	}

	protected abstract REQUEST_TYPE newRequest();

}
