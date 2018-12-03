package demo.repository;

import org.springframework.data.repository.CrudRepository;

import demo.vo.Shipment;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

	
}
