package demo.restServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.ShipmentNotFoundException;
import demo.repository.ShipmentRepository;
import demo.vo.Shipment;

@RestController
public class ShipmentController {

	@Autowired
	ShipmentRepository shipmentRepository;
	
//	@GetMapping(path = "/shoes/{serialNumber}")
//	public Shoes getShoes(@PathVariable Long serialNumber) {
//		
//		return shoesRepository.findBySerialNumber(serialNumber)
//				.orElseThrow(() -> new ShoesNotFoundException(serialNumber));
//		
//	}
	
	private static final Logger log = LogManager.getLogger(ShipmentController.class);
	
	@GetMapping(path = "/shipment/{id}")
	public Shipment getShipment(@PathVariable Long id) {
		log.info("getShipment called with id:["+id+"]");
		return shipmentRepository.findById(id)
				.orElseThrow(() -> new ShipmentNotFoundException(id));
	}
	
	@GetMapping(path = "/shipment")
	public Iterable<Shipment> getAllShipment() {
		log.info("getAllShipment called");
		return shipmentRepository.findAll();
	}
	
	@PostMapping("/shipment")
	Shipment newShipment(@RequestBody Shipment shipment) {
		log.info("newShipment called with shipment:["+shipment.toString()+"]");
		return shipmentRepository.save(shipment);
	}
	
	
//	@PutMapping("/order/{id}")
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

//	@DeleteMapping("/order/{customerOrder}")
//	void deleteEmployee(@PathVariable Long customerOrder) {
//		orderRepository.deleteByCustomerOrder(customerOrder);
//	}
	
}
