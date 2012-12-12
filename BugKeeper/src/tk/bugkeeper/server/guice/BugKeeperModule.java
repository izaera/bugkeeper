package tk.bugkeeper.server.guice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import tk.bugkeeper.server.app.BugKeeperServer;
import tk.bugkeeper.server.app.BugKeeperServerImpl;
import tk.bugkeeper.server.model.dao.EntityManager;
import tk.bugkeeper.server.model.dao.impl.UserDAO;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class BugKeeperModule extends AbstractModule implements Module {

	@Override
	protected void configure() {
		loadConfigPropertiesFile();
		bindSingletons();
		bindDAOs();
	}

	private void bindSingletons() {
		bind(BugKeeperServer.class).to(BugKeeperServerImpl.class).in(Singleton.class);
		bind(EntityManager.class).in(Singleton.class);
	}

	private void bindDAOs() {
		// DAOs are binded as singleton for optimization reasons
		bind(UserDAO.class).in(Singleton.class);
	}

	private void loadConfigPropertiesFile() {
        Properties properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
        	load( properties, is );
        } finally {
        	close(is);
        }
        Names.bindProperties( binder(), properties );
	}

	private void load(Properties properties, InputStream is) {
		try {
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException("Cannot load config.properties file",e);
		}
	}

	private void close(InputStream is) {
		try {
			is.close();
		} catch (IOException e) {
			// ignore
		}
	}

}
