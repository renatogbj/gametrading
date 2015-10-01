package br.com.gt.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.User;
import br.com.gt.model.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepository userRepository;

	public UserService() {
		super();
	}
	
	@Inject
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User save(User usr) {
		return userRepository.save(usr);
	}
	
	public void delete(User usr) {
		userRepository.delete(usr);
	}
	
	public User find(Long id) {
		return userRepository.findOne(id);
	}
	
	public User find(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return user;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}
}
