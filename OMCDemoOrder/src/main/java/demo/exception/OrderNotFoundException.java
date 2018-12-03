package demo.exception;

public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5772511272421176954L;

	public OrderNotFoundException(Long customerOrder) {
		super("Could not find Order with customerOrder:[" + customerOrder +"]");
	}
	
}
