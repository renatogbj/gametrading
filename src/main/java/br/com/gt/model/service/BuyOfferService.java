package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.BuyOffer;
import br.com.gt.model.bean.User;
import br.com.gt.model.repository.BuyOfferRepository;

@Service
public class BuyOfferService {

	@Autowired
	private BuyOfferRepository buyOfferRepository;
	
	public BuyOffer save(BuyOffer offer) {
		return buyOfferRepository.save(offer);
	}
	
	public void delete(BuyOffer offer) {
		buyOfferRepository.delete(offer);
	}
	
	public BuyOffer find(Long id) {
		return buyOfferRepository.findOne(id);
	}
	
	public List<BuyOffer> findAll() {
		return buyOfferRepository.findAll();
	}

	public List<BuyOffer> findByBidder(User bidder) {
		return buyOfferRepository.findByBidder(bidder);
	}
	
}
