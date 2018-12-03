package demo.restServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.PaymentNotFoundException;
import demo.repository.PaymentRepository;
import demo.vo.Payment;

@RestController
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;
	
//	@GetMapping(path = "/shoes/{serialNumber}")
//	public Shoes getShoes(@PathVariable Long serialNumber) {
//		
//		return shoesRepository.findBySerialNumber(serialNumber)
//				.orElseThrow(() -> new ShoesNotFoundException(serialNumber));
//		
//	}
	
	@GetMapping(path = "/payment/{id}")
	public Payment getPayment(@PathVariable Long id) {
		
		return paymentRepository.findById(id)
				.orElseThrow(() -> new PaymentNotFoundException(id));
		
	}
	
	@GetMapping(path = "/payment")
	public Iterable<Payment> getAllPayment() {
		return paymentRepository.findAll();
	}
	
	@PostMapping("/payment")
	Payment newPayment(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
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
