package model.exception;

// pode ser uma extends da RuntimeException (compilador nao obriga vc a tratar) ou exception (obriga vc a tratar) 
public class renatoException extends Exception{

	/**
	 * assumi o default
	 */
	private static final long serialVersionUID = 1L;
	
	public renatoException(String msg) {
		super(msg);
	}

}
