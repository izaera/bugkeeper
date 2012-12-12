package tk.bugkeeper.server;

import javax.servlet.ServletContextEvent;

import tk.bugkeeper.server.app.BugKeeperServer;
import tk.bugkeeper.server.guice.BugKeeperModule;
import tk.bugkeeper.server.guice.BugKeeperServletModule;
import tk.bugkeeper.server.morphia.CommonsLoggingMorphiaLogrFactory;

import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class Bootstrap extends GuiceServletContextListener {

	private static Bootstrap singleton;

	public static Bootstrap getInstance() {
		return singleton;
	}

	private Injector injector;
	
	public Bootstrap() {
		registerSingleton();
		initLogging();
		initInjector();
	}
	
	private void registerSingleton() {
		if( singleton!=null ) {
			throw new IllegalStateException("Only one instance of Bootstrap allowed");
		}
		singleton = this;
	}

	private void initLogging() {
		MorphiaLoggerFactory.registerLogger( CommonsLoggingMorphiaLogrFactory.class );
	}

	private void initInjector() {
		injector = Guice.createInjector( new BugKeeperServletModule(), new BugKeeperModule() );
	}

	@Override
	public Injector getInjector() {
		return injector;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		super.contextInitialized(servletContextEvent);
		injector.getInstance( BugKeeperServer.class ).start();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		injector.getInstance( BugKeeperServer.class ).stop();
		super.contextDestroyed(servletContextEvent);
	}
	
}
