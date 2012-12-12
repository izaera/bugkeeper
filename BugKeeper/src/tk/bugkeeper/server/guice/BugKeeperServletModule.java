package tk.bugkeeper.server.guice;

import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;

public class BugKeeperServletModule extends ServletModule implements Module {

	@Override
	protected void configureServlets() {
		super.configureServlets();
		
	}
	
}
