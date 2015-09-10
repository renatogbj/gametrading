package br.com.gt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Buy;
import br.com.gt.model.bean.BuyOffer;
import br.com.gt.model.bean.Sell;
import br.com.gt.model.bean.SellOffer;
import br.com.gt.model.bean.Trade;
import br.com.gt.model.bean.TradeOffer;
import br.com.gt.model.service.BuyOfferService;
import br.com.gt.model.service.BuyService;
import br.com.gt.model.service.SellOfferService;
import br.com.gt.model.service.SellService;
import br.com.gt.model.service.TradeOfferService;
import br.com.gt.model.service.TradeService;

@RestController
public class AnnouncementsController {

	@Autowired
	private SellService sellService;
	
	@Autowired
	private BuyService buyService;
	
	@Autowired
	private TradeService tradeService;
	
	@Autowired
	private SellOfferService sellOfferService;
	
	@Autowired
	private BuyOfferService buyOfferService;
	
	@Autowired
	private TradeOfferService tradeOfferService;
	
	@RequestMapping(value = "/announcements/buy", method = RequestMethod.GET)
	public List<Buy> findBuyAnnouncements() {
		return buyService.findAll();
	}
	
	@RequestMapping(value = "/announcements/sell", method = RequestMethod.GET)
	public List<Sell> findSellAnnouncements() {
		List<Sell> lista = sellService.findAll();
		return lista;
	}
	
	@RequestMapping(value = "/announcements/trade", method = RequestMethod.GET)
	public List<Trade> findTradeAnnouncements() {
		return tradeService.findAll();
	}
	
	@RequestMapping(value = "/announcements/sell/offer/add", method = RequestMethod.POST)
	public void addSellOffer(@RequestBody SellOffer offer) {
		sellOfferService.save(offer);
	}
	
	@RequestMapping(value = "/announcements/buy/offer/add", method = RequestMethod.POST)
	public void addBuyOffer(@RequestBody BuyOffer offer) {
		buyOfferService.save(offer);
	}
	
	@RequestMapping(value = "/announcements/trade/offer/add", method = RequestMethod.POST)
	public void addTradeOffer(@RequestBody TradeOffer offer) {
		tradeOfferService.save(offer);
	}
}
