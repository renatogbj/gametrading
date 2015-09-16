package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

	@Modifying
	@Query("UPDATE Trade t set t.traded = ?2 where t.id = ?1")
	void setTraded(Long id, boolean traded);

}
