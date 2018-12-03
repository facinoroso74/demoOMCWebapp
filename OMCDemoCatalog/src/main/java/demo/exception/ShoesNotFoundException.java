package demo.exception;

public class ShoesNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5772511272421176954L;

	public ShoesNotFoundException(Long serialNumber) {
		super("Could not find Shoes with serialNumber:[" + serialNumber+"]");
	}
	
	public ShoesNotFoundException(String productName) {
		super("Could not find Shoes with productName:[" + productName+"]");
	}
	
}
