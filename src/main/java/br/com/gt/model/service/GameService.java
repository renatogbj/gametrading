package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Game;
import br.com.gt.model.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;
	
	public Game save(Game game) {
		return gameRepo.save(game);
	}
	
	public void delete(Game game) {
		gameRepo.delete(game);
	}
	
	public Game find(Long id) {
		return gameRepo.findOne(id);
	}
	
	public List<Game> findAll() {
		return gameRepo.findAll();
	}
}
