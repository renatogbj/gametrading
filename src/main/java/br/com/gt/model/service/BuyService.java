package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Buy;
import br.com.gt.model.repository.BuyRepository;

@Service
public class BuyService {
	
	@Autowired
	private BuyRepository buyRepository;
	
	public Buy save(Buy buy) {
		return buyRepository.save(buy);
	}
	
	public void delete(Buy buy) {
		buyRepository.delete(buy);
	}
	
	public Buy find(Long id) {
		return buyRepository.findOne(id);
	}
	
	public List<Buy> findAll() {
		return buyRepository.findAll();
	}
}
