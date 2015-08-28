package br.com.gt.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Offer;
import br.com.gt.model.bean.Sell;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {

	@Modifying
	@Query("update Sell s set s.offers = ?2 where s.id = ?1")
	int updateOffers(Long id, List<Offer> offers);
}
