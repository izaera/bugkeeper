package tk.bugkeeper.client.app;

import tk.bugkeeper.client.model.data.impl.request.BugKeeperRequestFactory;

import com.google.code.ginmvp.client.GinMvpDisplay;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.UmbrellaException;

public class BugKeeperClientImpl implements BugKeeperClient, UncaughtExceptionHandler {
	
	private EventBus eventBus;
	private BugKeeperRequestFactory requestFactory;
	private GinMvpDisplay display;
	private PlaceHistoryHandler placeHistoryHandler;

	@Inject
	public BugKeeperClientImpl( final EventBus eventBus, final BugKeeperRequestFactory requestFactory, 
			final GinMvpDisplay display, final PlaceHistoryHandler placeHistoryHandler
	) {
		this.eventBus = eventBus;
		this.requestFactory = requestFactory;
		this.display = display;
		this.placeHistoryHandler = placeHistoryHandler;
	}

	@Override
	public void start() {
		GWT.setUncaughtExceptionHandler( this );
		requestFactory.initialize(eventBus);
        RootPanel.get().add(display);
        placeHistoryHandler.handleCurrentHistory();
	}

	@Override
	public void onUncaughtException(Throwable e) {
		Window.alert( explain(e) );
	}

	private String explain(Throwable e) {
		StringBuilder sb = new StringBuilder();
		if( e instanceof UmbrellaException ) {
			UmbrellaException ue = (UmbrellaException) e;
			sb.append("{{ BEGIN UMBRELLA\n\n");
			for( Throwable cause : ue.getCauses() ) {
				sb.append( explain(cause) );
				sb.append( "\n\n");
			}
			sb.append("END UMBRELLA }}\n");
		} else {
			sb.append( e.toString() );
			sb.append("\n");
			sb.append(getStackTrace(e));
		}
		return sb.toString();
	}
	
	private String getStackTrace(Throwable t) {
	    Object[] stackTrace = t.getStackTrace();
	    if (stackTrace != null) {
	    	int max = 3;
	        StringBuilder output = new StringBuilder();
	        for (Object line : stackTrace) {
	        	if( --max==0 ) break;
        	    output.append(line);
	            output.append("\n");
	        }
	        return output.toString();
	    } else {
	        return "[stack unavailable]";
	    }
	}

}
