package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Usr;
import br.com.gt.model.repository.UsrRepository;

@Service
public class UsrService {
	
	@Autowired
	private UsrRepository usrRepository;
	
	public Usr save(Usr usr) {
		return usrRepository.save(usr);
	}
	
	public void delete(Usr usr) {
		usrRepository.delete(usr);
	}
	
	public Usr find(Long id) {
		return usrRepository.findOne(id);
	}
	
	public List<Usr> findAll() {
		return usrRepository.findAll();
	}
}
