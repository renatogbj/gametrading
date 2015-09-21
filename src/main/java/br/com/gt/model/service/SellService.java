package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public void setSold(Long id, boolean sold) {
		sellRepository.setSold(id, sold);
	}

	@Transactional
	public void saveOrUpdate(Sell sell) {
		Sell dbSell = find(sell.getId());
		if (dbSell == null) {
			save(sell);
		} else {
			dbSell.setDescription(sell.getDescription());
			dbSell.setGame(sell.getGame());
			dbSell.setOffers(sell.getOffers());
			dbSell.setOwner(sell.getOwner());
			dbSell.setPrice(sell.getPrice());
			dbSell.setSold(sell.isSold());
		}
	}
}
