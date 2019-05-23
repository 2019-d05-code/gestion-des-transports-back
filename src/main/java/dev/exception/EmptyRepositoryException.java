package dev.exception;

public class EmptyRepositoryException extends Exception {

	public EmptyRepositoryException() {
		super();
	}
	
	public EmptyRepositoryException(String msg) {
		super(msg);
	}
	
}
