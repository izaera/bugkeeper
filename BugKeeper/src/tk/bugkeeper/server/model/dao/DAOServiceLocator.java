package tk.bugkeeper.server.model.dao;

import tk.bugkeeper.server.Bootstrap;

import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class DAOServiceLocator implements ServiceLocator {

	private Injector injector = Bootstrap.getInstance().getInjector();

	@Override
	public Object getInstance(Class<?> clazz) {
		return injector.getInstance(clazz);
	}

}
