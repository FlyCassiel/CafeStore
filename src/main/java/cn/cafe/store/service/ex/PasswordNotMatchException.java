package cn.cafe.store.service.ex;

public class PasswordNotMatchException extends RuntimeException {

	/**
	 * 登录密码不正确异�?
	 */
	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
