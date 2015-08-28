package br.com.gt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Buy;
import br.com.gt.model.bean.Sell;
import br.com.gt.model.bean.Trade;
import br.com.gt.model.service.BuyService;
import br.com.gt.model.service.SellService;
import br.com.gt.model.service.TradeService;

@RestController
public class AnnouncementsController {

	@Autowired
	private SellService sellService;
	
	@Autowired
	private BuyService buyService;
	
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(value = "/announcements/buy", method = RequestMethod.GET)
	public List<Buy> findSellAnnouncements() {
		return buyService.findAll();
	}
	
	@RequestMapping(value = "/announcements/sell", method = RequestMethod.GET)
	public List<Sell> findBuyAnnouncements() {
		return sellService.findAll();
	}
	
	@RequestMapping(value = "/announcements/trade", method = RequestMethod.GET)
	public List<Trade> findTradeAnnouncements() {
		return tradeService.findAll();
	}
	
	@RequestMapping(value = "/announcements/offer/add", method = RequestMethod.POST)
	public void addOfferToSell(@RequestBody Sell sell) {
		int i = sellService.updateOffers(sell);
		System.out.println(i);
	}
}
