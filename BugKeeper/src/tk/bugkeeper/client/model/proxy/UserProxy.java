package tk.bugkeeper.client.model.proxy;

import tk.bugkeeper.server.model.dao.impl.UserDAO;
import tk.bugkeeper.server.model.entity.impl.User;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=User.class,locator=UserDAO.class)
public interface UserProxy extends EntityProxy {
	String getUser();
	void setPassword( String password );
}
