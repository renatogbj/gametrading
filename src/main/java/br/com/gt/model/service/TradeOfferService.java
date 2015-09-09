package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.TradeOffer;
import br.com.gt.model.repository.TradeOfferRepository;

@Service
public class TradeOfferService {

	@Autowired
	private TradeOfferRepository tradeOfferRepository;
	
	public TradeOffer save(TradeOffer offer) {
		return tradeOfferRepository.save(offer);
	}
	
	public void delete(TradeOffer offer) {
		tradeOfferRepository.delete(offer);
	}
	
	public TradeOffer find(Long id) {
		return tradeOfferRepository.findOne(id);
	}
	
	public List<TradeOffer> findAll() {
		return tradeOfferRepository.findAll();
	}
}
