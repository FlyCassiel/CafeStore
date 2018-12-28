package cn.cafe.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException {

	/**
	 * 注册  注册名被占用异常
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistException() {
		super();
	}

	public UsernameAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlreadyExistException(String message) {
		super(message);
	}

	public UsernameAlreadyExistException(Throwable cause) {
		super(cause);
	}
	

}
