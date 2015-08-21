package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Sell;
import br.com.gt.model.repository.SellRepository;

@Service
public class SellService {

	@Autowired
	private SellRepository sellRepo;
	
	public Sell save(Sell sell) {
		return sellRepo.save(sell);
	}
	
	public void delete(Sell sell) {
		sellRepo.delete(sell);
	}
	
	public Sell find(Long id) {
		return sellRepo.findOne(id);
	}
	
	public List<Sell> findAll() {
		return sellRepo.findAll();
	}
}
