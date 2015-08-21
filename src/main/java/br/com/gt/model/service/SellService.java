package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Sell;
import br.com.gt.model.repository.SellRepository;

@Service
public class SellService {

	@Autowired
	private SellRepository sellRepository;
	
	public Sell save(Sell sell) {
		return sellRepository.save(sell);
	}
	
	public void delete(Sell sell) {
		sellRepository.delete(sell);
	}
	
	public Sell find(Long id) {
		return sellRepository.findOne(id);
	}
	
	public List<Sell> findAll() {
		return sellRepository.findAll();
	}
}
