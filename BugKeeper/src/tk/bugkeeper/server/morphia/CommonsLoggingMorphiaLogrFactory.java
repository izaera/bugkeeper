package tk.bugkeeper.server.morphia;

import org.apache.commons.logging.LogFactory;

import com.google.code.morphia.logging.Logr;
import com.google.code.morphia.logging.LogrFactory;

public class CommonsLoggingMorphiaLogrFactory implements LogrFactory {

	@Override
	public Logr get(Class<?> clazz) {
		return new CommonsLoggingMorphiaLogr( LogFactory.getLog(clazz) );
	}

}
