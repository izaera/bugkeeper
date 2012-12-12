package tk.bugkeeper.client.model.data.impl.request;

import tk.bugkeeper.client.model.data.UserDataService.LoginResult;
import tk.bugkeeper.server.model.dao.DAOServiceLocator;
import tk.bugkeeper.server.model.dao.impl.UserDAO;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value=UserDAO.class,locator=DAOServiceLocator.class)
public interface UserDataServiceRequest extends RequestContext {
	Request<LoginResult> login( String user, String password );
}
