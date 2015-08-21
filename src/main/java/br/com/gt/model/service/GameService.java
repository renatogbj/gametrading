package br.com.gt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gt.model.bean.Game;
import br.com.gt.model.enums.Platform;
import br.com.gt.model.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public Game save(Game game) {
		return gameRepository.save(game);
	}
	
	public void delete(Game game) {
		gameRepository.delete(game);
	}
	
	public Game find(Long id) {
		return gameRepository.findOne(id);
	}
	
	/**
	 * The {@code name} and {@code platform} together are unique.
	 * @param name The name of the game.
	 * @param platform The platform of the game.
	 * @return The {@code Game} on the database.
	 */
	public Game find(String name, Platform platform) {
		return gameRepository.findGameByNameAndPlatform(name, platform);
	}
	
	public List<Game> findAll() {
		return gameRepository.findAll();
	}
}
