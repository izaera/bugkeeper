package tk.bugkeeper.client.resource;

import com.google.gwt.core.client.*;
import com.google.gwt.resources.client.*;

public interface Resources extends ClientBundle {
	
	public static final Resources instance = GWT.create(Resources.class);
	
	@Source("camera48.png") ImageResource cameraImage();
}
