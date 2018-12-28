package cn.cafe.store.bean;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable{
	/**
	 * ĞòÁĞ»¯
	 */
	private static final long serialVersionUID = 1L;
	private Integer state;
    private String message;
    private T data;
	public ResponseResult(Integer state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}
	
	public ResponseResult(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}

	public ResponseResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseResult other = (ResponseResult) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
