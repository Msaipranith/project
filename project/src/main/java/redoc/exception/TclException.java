package redoc.exception;

@SuppressWarnings("serial")
public class TclException extends Exception {

//	private int statusCode = 500;
//	private String msg = "Internal Server Error";

	private int statusCode ;
	private String msg;

//	
//	public TclException(String msg, int statusCode) {
//
//		super(msg);
//		this.statusCode = statusCode != 0 ? statusCode : this.statusCode;
//		this.msg = msg;
//
//	}
//	

	public TclException(String msg, int statusCode) {

		super(msg);
		this.statusCode = statusCode;
		this.msg = msg;

	}

	public TclException(String msg, Throwable throwable, int statusCode) {
		super(throwable);
		this.statusCode = statusCode != 0 ? statusCode : this.statusCode;
		this.msg = msg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
