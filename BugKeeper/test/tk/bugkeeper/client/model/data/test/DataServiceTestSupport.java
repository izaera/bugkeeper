package tk.bugkeeper.client.model.data.test;

import static org.mockito.Mockito.*;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubber;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public final class DataServiceTestSupport {
	
	public static Stubber returnSuccessWithResult( final Object result ) {
		return doAnswer( new Answer<Void>() {
			@SuppressWarnings("unchecked")
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Receiver<Object> receiver = (Receiver<Object>)args[2];
				receiver.onSuccess(result);
				return null;
			}
		});
	}
	
	public static Stubber returnFailureWithError( final ServerFailure error ) {
		return doAnswer( new Answer<Void>() {
			@SuppressWarnings("unchecked")
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Receiver<Object> receiver = (Receiver<Object>)args[2];
				receiver.onFailure(error);
				return null;
			}
		});
	}
}
