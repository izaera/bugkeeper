package tk.bugkeeper.client.model.data;

import com.google.web.bindery.requestfactory.shared.*;

public interface DataService<PROXY_TYPE extends EntityProxy> {
	PROXY_TYPE edit( PROXY_TYPE proxy );
}
