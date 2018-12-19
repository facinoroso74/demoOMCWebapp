package demo.restServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.ShoesNotFoundException;
import demo.filter.CorrelationIdFilter;
import demo.repository.ShoesRepository;
import demo.vo.Shoes;

@RestController
public class ShoesController {

	@Autowired
	ShoesRepository shoesRepository;
	
	private static final Logger log = LogManager.getLogger(CorrelationIdFilter.class);

	
//	@GetMapping(path = "/shoes/{serialNumber}")
//	public Shoes getShoes(@PathVariable Long serialNumber) {
//		
//		return shoesRepository.findBySerialNumber(serialNumber)
//				.orElseThrow(() -> new ShoesNotFoundException(serialNumber));
//		
//	}
	
	@GetMapping(path = "/shoes/{productName}")
	public Shoes getShoes(@PathVariable String productName) {
		
		log.info("getShoes invoked with productName:["+productName+"] ...");
		Shoes shoes = shoesRepository.findByProductName(productName).orElseThrow(() -> new ShoesNotFoundException(productName));
		log.info("getShoes invoked with productName:["+productName+"] DONE");
		return shoes;
	}
	
	@GetMapping(path = "/shoes")
	public Iterable<Shoes> getAllShoes() {
		log.info("getAllShoes invoked ...");
		Iterable<Shoes> shoes = shoesRepository.findAll();
		log.info("getAllShoes invoked ...DONE");
		return shoes;
	}
	
	@PostMapping("/shoes")
	Shoes newShoes(@RequestBody Shoes shoes) {
		return shoesRepository.save(shoes);
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

	@DeleteMapping("/shoes/{id}")
	void deleteEmployee(@PathVariable Long serialNumber) {
		shoesRepository.deleteBySerialNumber(serialNumber);
	}
	
}
