package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.BuyOfferAnswer;
import br.com.gt.model.repository.BuyOfferAnswerRepository;

@Service
public class BuyOfferAnswerService {

	@Autowired
	private BuyOfferAnswerRepository buyOfferAnswerRepository;
	
	public BuyOfferAnswer save(BuyOfferAnswer answer) {
		return buyOfferAnswerRepository.save(answer);
	}
	
	public void delete(BuyOfferAnswer answer) {
		buyOfferAnswerRepository.delete(answer);
	}
	
	public BuyOfferAnswer find(Long id) {
		return buyOfferAnswerRepository.findOne(id);
	}
	
	public List<BuyOfferAnswer> findAll() {
		return buyOfferAnswerRepository.findAll();
	}
	
}
