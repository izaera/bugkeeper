package tk.bugkeeper.client.gin;


import tk.bugkeeper.client.app.BugKeeperClient;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(BugKeeperGinModule.class)
public interface BugKeeperGinjector extends Ginjector {
	BugKeeperClient getApplication();
}
