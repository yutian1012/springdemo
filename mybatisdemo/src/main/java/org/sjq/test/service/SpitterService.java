package org.sjq.test.service;

import javax.annotation.Resource;

import org.sjq.test.db.SpitterRepository;
import org.sjq.test.model.Spitter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpitterService {
	@Resource
	private SpitterRepository spitterRepository;
	
	public Spitter getByUsername(String username) {
		return spitterRepository.findByUsername(username);
	}
	
	public Spitter save(Spitter spitter) {
		spitterRepository.save(spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(), spitter.isUpdateByEmail(), spitter.getStatus());
		return spitter;
	}
}
