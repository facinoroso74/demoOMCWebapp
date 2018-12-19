package demo.exception;

public class PaymentNotExecutedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5772511272421176954L;

	public PaymentNotExecutedException(Long id) {
		super("Could not executing the Payment with id:[" + id+"]");
	}
	
}
