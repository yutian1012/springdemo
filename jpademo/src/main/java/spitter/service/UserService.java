package spitter.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spittr.db.UserRepository;
import spittr.domain.User;

@Service
@Transactional
public class UserService {
	@Resource
	private UserRepository userRepository;
	
	public User addUser(User u) {
		return userRepository.save(u);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}
}
