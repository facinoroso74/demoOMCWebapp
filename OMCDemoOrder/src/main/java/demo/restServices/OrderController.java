package demo.restServices;

import java.sql.Timestamp;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.exception.OrderNotFoundException;
import demo.repository.OrderRepository;
import demo.vo.Order;

@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
//	@GetMapping(path = "/shoes/{serialNumber}")
//	public Shoes getShoes(@PathVariable Long serialNumber) {
//		
//		return shoesRepository.findBySerialNumber(serialNumber)
//				.orElseThrow(() -> new ShoesNotFoundException(serialNumber));
//		
//	}
	
	private static final Logger log = LogManager.getLogger(OrderController.class);
	
	@GetMapping(path = "/order/{customerOrder}")
	public Order getOrder(@PathVariable Long customerOrder) {
		log.info("getOrder called with customerOrder:["+customerOrder+"]");
		
		return orderRepository.findByCustomerOrder(customerOrder)
				.orElseThrow(() -> new OrderNotFoundException(customerOrder));
	}
	
	@GetMapping(path = "/order")
	public Iterable<Order> getAllOrder() {
		log.info("getAllOrder called");
		return orderRepository.findAll();
	}
	
	@PostMapping("/order")
	Order newCustomerOrder(@RequestBody Order order) {
		log.info("newCustomerOrder called with order:["+order+"]");
		order.setDateOrder(new Timestamp(System.currentTimeMillis()));
		return orderRepository.save(order);
	}
	
	@PutMapping("/order/{newOrder}")
	Order updateOrder(@RequestBody Order newOrder) {
		log.info("updateOrder called with order:["+newOrder+"]");
		newOrder.setDateOrder(new Timestamp(System.currentTimeMillis()));
		newOrder.setStatus("PENDING PAYMENT");
		return orderRepository.save(newOrder);
			
	}

//	@DeleteMapping("/order/{customerOrder}")
//	void deleteEmployee(@PathVariable Long customerOrder) {
//		orderRepository.deleteByCustomerOrder(customerOrder);
//	}
	
}
