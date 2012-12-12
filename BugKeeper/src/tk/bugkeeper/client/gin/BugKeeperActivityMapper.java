package tk.bugkeeper.client.gin;


import tk.bugkeeper.client.ui.activity.home.HomeActivity;
import tk.bugkeeper.client.ui.activity.home.HomePlace;
import tk.bugkeeper.client.ui.activity.login.LoginActivity;
import tk.bugkeeper.client.ui.activity.login.LoginPlace;

import com.google.code.ginmvp.client.SimpleActivityMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class BugKeeperActivityMapper extends SimpleActivityMapper {

	@Inject
    public BugKeeperActivityMapper(
		final Provider<LoginActivity> loginProvider,
		final Provider<HomeActivity> homeProvider
    ) {
	    addProvider(LoginPlace.class, loginProvider);
	    addProvider(HomePlace.class, homeProvider);
    }    
 
}
