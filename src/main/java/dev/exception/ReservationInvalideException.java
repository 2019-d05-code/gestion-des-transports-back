package dev.exception;

public class ReservationInvalideException extends RuntimeException {
	
	public ReservationInvalideException() {
		super();
	}
	
	public ReservationInvalideException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReservationInvalideException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	public ReservationInvalideException(String message) {
		super(message); 
	}
	public ReservationInvalideException(Throwable cause) {
		super(cause); 
	}
	
	
}
