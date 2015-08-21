package br.com.gt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gt.model.bean.Game;
import br.com.gt.model.bean.Sell;
import br.com.gt.model.service.GameService;
import br.com.gt.model.service.SellService;

@RestController
public class AnnounceController {

	@Autowired
	private SellService sellService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(value = "/announce/sell/save", method = RequestMethod.POST)
	public Sell save(@RequestBody Sell sell) {
		System.out.println("Saving bean: " + sell);
		return sellService.save(sell);
	}
	
	@RequestMapping(value = "/announce/games", method = RequestMethod.GET)
	public List<Game> findGames() {
		return gameService.findAll();
	}
}
