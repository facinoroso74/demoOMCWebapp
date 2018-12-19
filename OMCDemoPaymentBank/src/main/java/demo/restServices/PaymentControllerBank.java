package demo.restServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.PaymentNotExecutedException;
import demo.vo.Payment;

@RestController
public class PaymentControllerBank {

	
	private static final Logger log = LogManager.getLogger(PaymentControllerBank.class);
	
//	@GetMapping(path = "/shoes/{serialNumber}")
//	public Shoes getShoes(@PathVariable Long serialNumber) {
//		
//		return shoesRepository.findBySerialNumber(serialNumber)
//				.orElseThrow(() -> new ShoesNotFoundException(serialNumber));
//		
//	}
//	
//	@GetMapping(path = "/payment/{id}")
//	public Payment getPayment(@PathVariable Long id) {
//		
//		return paymentRepository.findById(id)
//				.orElseThrow(() -> new PaymentNotFoundException(id));
//		
//	}
	
//	@GetMapping(path = "/payment")
//	public Iterable<Payment> getAllPayment() {
//		return paymentRepository.findAll();
//	}
	
	@PostMapping("/payment")
	Payment newPayment(@RequestBody Payment payment) {
		try {
			log.info("executing the payment:["+payment+"]...");
			
			log.info("executing the payment:["+payment+"]... DONE");
			return payment;
		}catch (Exception e) {
			log.error("Exception on newPayment",e);
			throw new PaymentNotExecutedException(payment.getSerialNumber());
		}
	}
	
//	@PutMapping("/shoes/{id}")
//	Shoes replaceShoes(@RequestBody Shoes newShoes, @PathVariable Long serialNumber) {
//
//		return shoesRepository.findBySerialNumber(serialNumber)
//			.map(shoes -> {
//				shoes.setImageId(newShoes.getName());
//				shoes.setPrice(newShoes.getRole());
//				shoes.setProductName(newShoes.getRole());
//				return shoesRepository.save(employee);
//			})
//			.orElseGet(() -> {
//				newShoes.setId(id);
//				return shoesRepository.save(newShoes);
//			});
//	}

//	@DeleteMapping("/payment/{id}")
//	void deleteEmployee(@PathVariable Long serialNumber) {
//		shoesRepository.deleteBySerialNumber(serialNumber);
//	}
	
}
