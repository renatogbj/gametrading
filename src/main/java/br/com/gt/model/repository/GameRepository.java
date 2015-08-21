package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Game;
import br.com.gt.model.enums.Platform;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	public Game findGameByNameAndPlatform(String name, Platform platform);
	
}
