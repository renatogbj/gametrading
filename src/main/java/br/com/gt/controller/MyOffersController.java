package br.com.gt.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Buy;
import br.com.gt.model.bean.BuyOffer;
import br.com.gt.model.bean.BuyOfferAnswer;
import br.com.gt.model.bean.Sell;
import br.com.gt.model.bean.SellOffer;
import br.com.gt.model.bean.SellOfferAnswer;
import br.com.gt.model.bean.Trade;
import br.com.gt.model.bean.TradeOffer;
import br.com.gt.model.bean.TradeOfferAnswer;
import br.com.gt.model.bean.Usr;
import br.com.gt.model.service.BuyOfferAnswerService;
import br.com.gt.model.service.BuyOfferService;
import br.com.gt.model.service.SellOfferAnswerService;
import br.com.gt.model.service.SellOfferService;
import br.com.gt.model.service.TradeOfferAnswerService;
import br.com.gt.model.service.TradeOfferService;
import br.com.gt.model.service.UsrService;

@RestController
public class MyOffersController {

	@Autowired
	private UsrService userService;
	
	@Autowired
	private SellOfferService sellOfferService;
	
	@Autowired
	private BuyOfferService buyOfferService;
	
	@Autowired
	private TradeOfferService tradeOfferService;
	
	@Autowired
	private SellOfferAnswerService sellOfferAnswerService;
	
	@Autowired
	private BuyOfferAnswerService buyOfferAnswerService;
	
	@Autowired
	private TradeOfferAnswerService tradeOfferAnswerService;
	
	@RequestMapping(value = "/myoffers/sell", method = RequestMethod.GET)
	public Set<Sell> findSellAnnouncements(@RequestParam("userEmail") String userEmail) {
		Usr user = userService.find(userEmail);
		
		List<SellOffer> offers = sellOfferService.findByBidder(user);
		Set<Sell> sell = new HashSet<>();
		
		for (SellOffer offer : offers) {
			sell.add(offer.getSell());
		}
		
		return sell;
	}
	
	@RequestMapping(value = "/myoffers/buy", method = RequestMethod.GET)
	public Set<Buy> findBuyAnnouncements(@RequestParam("userEmail") String userEmail) {
		Usr user = userService.find(userEmail);
		
		List<BuyOffer> offers = buyOfferService.findByBidder(user);
		Set<Buy> buy = new HashSet<>();
		
		for (BuyOffer offer : offers) {
			buy.add(offer.getBuy());
		}
		
		return buy;
	}
	
	@RequestMapping(value = "/myoffers/trade", method = RequestMethod.GET)
	public Set<Trade> findTradeAnnouncements(@RequestParam("userEmail") String userEmail) {
		Usr user = userService.find(userEmail);
		
		List<TradeOffer> offers = tradeOfferService.findByBidder(user);
		Set<Trade> trade = new HashSet<>();
		
		for (TradeOffer offer : offers) {
			trade.add(offer.getTrade());
		}
		
		return trade;
	}
	
	@RequestMapping(value = "/myoffers/sell/answer/add", method = RequestMethod.POST)
	public void addSellOfferAnswer(@RequestBody SellOfferAnswer answer) {
		sellOfferAnswerService.save(answer);
	}
	
	@RequestMapping(value = "/myoffers/buy/answer/add", method = RequestMethod.POST)
	public void addBuyOfferAnswer(@RequestBody BuyOfferAnswer answer) {
		buyOfferAnswerService.save(answer);
	}
	
	@RequestMapping(value = "/myoffers/trade/answer/add", method = RequestMethod.POST)
	public void addTradeOfferAnswer(@RequestBody TradeOfferAnswer answer) {
		tradeOfferAnswerService.save(answer);
	}
	
}
