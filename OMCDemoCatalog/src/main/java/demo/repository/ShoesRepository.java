package demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import demo.vo.Shoes;

public interface ShoesRepository extends CrudRepository<Shoes, Long> {

	public Optional<Shoes> findBySerialNumber(Long serialNumber);

	public void deleteBySerialNumber(Long serialNumber);
	
}
