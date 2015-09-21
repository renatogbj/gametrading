package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.SellOfferAnswer;
import br.com.gt.model.repository.SellOfferAnswerRepository;

@Service
public class SellOfferAnswerService {
	
	@Autowired
	private SellOfferAnswerRepository sellOfferAnswerRepository;
	
	public SellOfferAnswer save(SellOfferAnswer answer) {
		return sellOfferAnswerRepository.save(answer);
	}
	
	public void delete(SellOfferAnswer answer) {
		sellOfferAnswerRepository.delete(answer);
	}
	
	public SellOfferAnswer find(Long id) {
		return sellOfferAnswerRepository.findOne(id);
	}
	
	public List<SellOfferAnswer> findAll() {
		return sellOfferAnswerRepository.findAll();
	}
	
}
