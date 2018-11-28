package demo.exception;

public class ShoesNotFoundException extends RuntimeException {

	public ShoesNotFoundException(Long serialNumber) {
		super("Could not find Shoes with serialNumber:[" + serialNumber+"]");
	}
}
