package demo.restServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.ShoesNotFoundException;
import demo.repository.ShoesRepository;
import demo.vo.Shoes;

@RestController
public class ShoesController {

	@Autowired
	ShoesRepository shoesRepository;
	
	@GetMapping(path = "/shoes/{serialNumber}")
	public Shoes getShoes(@PathVariable Long serialNumber) {
		
		return shoesRepository.findBySerialNumber(serialNumber)
				.orElseThrow(() -> new ShoesNotFoundException(serialNumber));
		
	}
	
	@GetMapping(path = "/shoes")
	public Iterable<Shoes> getAllShoes() {
		return shoesRepository.findAll();
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
