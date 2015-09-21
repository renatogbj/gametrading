package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.TradeOfferAnswer;
import br.com.gt.model.repository.TradeOfferAnswerRepository;

@Service
public class TradeOfferAnswerService {

	@Autowired
	private TradeOfferAnswerRepository tradeOfferAnswerRepository;
	
	public TradeOfferAnswer save(TradeOfferAnswer answer) {
		return tradeOfferAnswerRepository.save(answer);
	}
	
	public void delete(TradeOfferAnswer answer) {
		tradeOfferAnswerRepository.delete(answer);
	}
	
	public TradeOfferAnswer find(Long id) {
		return tradeOfferAnswerRepository.findOne(id);
	}
	
	public List<TradeOfferAnswer> findAll() {
		return tradeOfferAnswerRepository.findAll();
	}
	
}
