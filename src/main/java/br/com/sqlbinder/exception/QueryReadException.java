package br.com.sqlbinder.exception;

public class QueryReadException extends Exception {

	private static final long serialVersionUID = 2999271916803750669L;

	public QueryReadException(String message) {
		super(message);
	}

	public QueryReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QueryReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryReadException(Throwable cause) {
		super(cause);
	}
}
