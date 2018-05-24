package spitter.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spittr.db.AddressRepository;
import spittr.domain.Address;

@Service
@Transactional
public class AddressService {
	@Resource
	private AddressRepository addressRepository;
	
	public Address add(Address address) {
		return addressRepository.save(address);
	}
	
	public Address findById(Long id) {
		return addressRepository.findOne(id);
	}
}
