package br.com.gt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Buy;
import br.com.gt.model.bean.Game;
import br.com.gt.model.bean.Sell;
import br.com.gt.model.bean.Trade;
import br.com.gt.model.service.BuyService;
import br.com.gt.model.service.GameService;
import br.com.gt.model.service.SellService;
import br.com.gt.model.service.TradeService;

@RestController
public class AnnounceController {

	@Autowired
	private SellService sellService;
	
	@Autowired
	private BuyService buyService;
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(value = "/announce/sell/save", method = RequestMethod.POST)
	public Sell save(@RequestBody Sell sell) {
		return sellService.save(sell);
	}
	
	@RequestMapping(value = "/announce/buy/save", method = RequestMethod.POST)
	public Buy save(@RequestBody Buy buy) {
		return buyService.save(buy);
	}
	
	@RequestMapping(value = "/announce/trade/save", method = RequestMethod.POST)
	public Trade save(@RequestBody Trade trade) {
		return tradeService.save(trade);
	}
	
	@RequestMapping(value = "/announce/games", method = RequestMethod.GET)
	public List<Game> findGames() {
		return gameService.findAll();
	}
	
}
