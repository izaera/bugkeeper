package tk.bugkeeper.server.morphia;

import java.util.Formatter;

import org.apache.commons.logging.Log;

import com.google.code.morphia.logging.Logr;

public class CommonsLoggingMorphiaLogr implements Logr {

	private static final long serialVersionUID = 1L;

	private Log log;
	
	public CommonsLoggingMorphiaLogr( final Log log ) {
		this.log = log;
	}

	@Override
	public void debug(final String arg0, final Throwable arg1) {
		log.debug(arg0, arg1);
	}

	@Override
	public void debug(final String arg0) {
		log.debug(arg0);
	}

	@Override
	public void error(final String arg0, final Throwable arg1) {
		log.error(arg0, arg1);
	}

	@Override
	public void error(final String arg0) {
		log.error(arg0);
	}

	public void fatal(final String arg0, final Throwable arg1) {
		log.fatal(arg0, arg1);
	}

	public void fatal(final String arg0) {
		log.fatal(arg0);
	}

	@Override
	public void info(final String arg0, final Throwable arg1) {
		log.info(arg0, arg1);
	}

	@Override
	public void info(final String arg0) {
		log.info(arg0);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	public boolean isFatalEnabled() {
		return log.isFatalEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	@Override
	public boolean isWarningEnabled() {
		return log.isWarnEnabled();
	}

	@Override
	public void trace(final String arg0, final Throwable arg1) {
		log.trace(arg0, arg1);
	}

	@Override
	public void trace(final String arg0) {
		log.trace(arg0);
	}

	@Override
	public void warning(final String arg0, final Throwable arg1) {
		log.warn(arg0, arg1);
	}

	@Override
	public void warning(final String arg0) {
		log.warn(arg0);
	}

	@Override
	public void debug(String arg0, Object... arg1) {
		log.debug( format(arg0, arg1) );
	}

	@Override
	public void error(String arg0, Object... arg1) {
		log.error( format(arg0, arg1) );
	}

	@Override
	public void info(String arg0, Object... arg1) {
		log.info( format(arg0, arg1) );
	}

	@Override
	public void trace(String arg0, Object... arg1) {
		log.trace( format(arg0, arg1) );
	}

	@Override
	public void warning(String arg0, Object... arg1) {
		log.warn( format(arg0, arg1) );
	}

	private String format(String format, Object... args) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);
		formatter.format( format, args );
		formatter.close();
		return sb.toString();
	}

}
