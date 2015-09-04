package br.com.gt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Sell;
import br.com.gt.model.service.SellService;

@RestController
public class MyGamesController {

	@Autowired
	private SellService sellService;
	
	@RequestMapping(value = "/mygames/sell", method = RequestMethod.GET)
	public List<Sell> findMySellAnnouncements() {
		return sellService.findAll();
	}
	
	@RequestMapping(value = "/mygames/sell/remove", method = RequestMethod.POST)
	public void removeMySellAnnouncement(@RequestBody Sell sell) {
		sellService.delete(sell);
	}
	
	@RequestMapping(value = "/mygames/sell/sold", method = RequestMethod.POST)
	public void setSold(@RequestBody Sell sell) {
		sellService.setSold(sell.getId(), sell.isSold());
	}
}
