package br.com.gt.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Sell;
import br.com.gt.model.bean.SellOffer;

@Repository
public interface SellOfferRepository extends JpaRepository<SellOffer, Long> {

	List<SellOffer> findBySell(Sell sell);

}
