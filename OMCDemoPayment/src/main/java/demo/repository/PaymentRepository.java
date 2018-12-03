package demo.repository;

import org.springframework.data.repository.CrudRepository;

import demo.vo.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

	
}
