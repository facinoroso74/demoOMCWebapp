package demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import demo.vo.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	public Optional<Order> findByCustomerOrder(Long customerOrder);

	public void deleteByCustomerOrder(Long customerOrder);

	
}
