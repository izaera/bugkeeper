package tk.bugkeeper.client;

import tk.bugkeeper.client.gin.BugKeeperGinjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class BugKeeperEntryPoint implements EntryPoint {
	
    private final BugKeeperGinjector ginjector = GWT.create(BugKeeperGinjector.class);

    @Override
	public void onModuleLoad() {
        ginjector.getApplication().start();
	}

}
