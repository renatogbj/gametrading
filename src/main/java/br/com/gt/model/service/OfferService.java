package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Offer;
import br.com.gt.model.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	public Offer save(Offer offer) {
		return offerRepository.save(offer);
	}
	
	public void delete(Offer offer) {
		offerRepository.delete(offer);
	}
	
	public Offer find(Long id) {
		return offerRepository.findOne(id);
	}
	
	public List<Offer> findAll() {
		return offerRepository.findAll();
	}
}
