package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Sell;
import br.com.gt.model.bean.SellOffer;
import br.com.gt.model.repository.SellOfferRepository;

@Service
public class SellOfferService {

	@Autowired
	private SellOfferRepository sellOfferRepository;
	
	public SellOffer save(SellOffer offer) {
		return sellOfferRepository.save(offer);
	}
	
	public void delete(SellOffer offer) {
		sellOfferRepository.delete(offer);
	}
	
	public SellOffer find(Long id) {
		return sellOfferRepository.findOne(id);
	}
	
	public List<SellOffer> findAll() {
		return sellOfferRepository.findAll();
	}

	public List<SellOffer> findOffers(Sell sell) {
		return sellOfferRepository.findBySell(sell);
	}
}
