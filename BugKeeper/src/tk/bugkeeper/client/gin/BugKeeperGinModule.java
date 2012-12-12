package tk.bugkeeper.client.gin;

import tk.bugkeeper.client.app.BugKeeperClient;
import tk.bugkeeper.client.app.BugKeeperClientImpl;
import tk.bugkeeper.client.model.data.UserDataService;
import tk.bugkeeper.client.model.data.impl.UserDataServiceImpl;
import tk.bugkeeper.client.model.data.impl.request.BugKeeperRequestFactory;
import tk.bugkeeper.client.ui.activity.login.LoginPlace;
import tk.bugkeeper.client.ui.view.home.HomeView;
import tk.bugkeeper.client.ui.view.home.impl.DefaultHomeView;
import tk.bugkeeper.client.ui.view.login.LoginView;
import tk.bugkeeper.client.ui.view.login.impl.DefaultLoginView;

import com.google.code.ginmvp.client.GinMvpModule;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class BugKeeperGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		installGinMvp();
		bindSingletons();
		bindDataServices();
		bindViews();
	}

	private void bindViews() {
		bind(LoginView.class).to(DefaultLoginView.class).in(Singleton.class);
		bind(HomeView.class).to(DefaultHomeView.class).in(Singleton.class);
	}

	private void bindDataServices() {
		bind(UserDataService.class).to(UserDataServiceImpl.class);
	}

	private void bindSingletons() {
		bind(BugKeeperClient.class).to(BugKeeperClientImpl.class).in(Singleton.class);
		bind(BugKeeperRequestFactory.class).in(Singleton.class);
	}

	private void installGinMvp() {
		install( new GinMvpModule(BugKeeperActivityMapper.class,LoginPlace.class) );
	}

}
