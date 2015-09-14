package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {
	
	@Modifying
	@Query("UPDATE Buy b set b.bought = ?2 where b.id = ?1")
	void setBought(Long id, boolean bought);
	
}
