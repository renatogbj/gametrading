package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Trade;
import br.com.gt.model.repository.TradeRepository;

@Service
public class TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	
	public Trade save(Trade trade) {
		return tradeRepository.save(trade);
	}
	
	public void delete(Trade trade) {
		tradeRepository.delete(trade);
	}
	
	public Trade find(Long id) {
		return tradeRepository.findOne(id);
	}
	
	public List<Trade> findAll() {
		return tradeRepository.findAll();
	}
}
