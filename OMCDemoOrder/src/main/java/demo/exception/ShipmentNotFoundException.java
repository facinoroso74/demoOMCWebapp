package demo.exception;

public class ShipmentNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3113712248664139499L;

	public ShipmentNotFoundException(Long id) {
		super("Could not find Shipment with id:[" + id+"]");
	}
	
}
