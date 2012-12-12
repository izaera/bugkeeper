package tk.bugkeeper.client.ui;



import com.google.web.bindery.requestfactory.shared.EntityProxy;

public interface EditorView<PROXY_TYPE extends EntityProxy,PRESENTER_TYPE> extends View<PRESENTER_TYPE> {

	void setCreationEnabled( boolean creationEnabled );
	
	void loadFieldsFrom( PROXY_TYPE camera );
	void storeFieldsTo( PROXY_TYPE camera );

}
