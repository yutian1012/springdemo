package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
}
