package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Sell;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {

	@Modifying
	@Query("UPDATE Sell s set s.sold = ?2 where s.id = ?1")
	void setSold(Long id, boolean sold);
	
}
