package demo.exception;

public class PaymentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5772511272421176954L;

	public PaymentNotFoundException(Long id) {
		super("Could not find Payment with id:[" + id+"]");
	}
	
}
