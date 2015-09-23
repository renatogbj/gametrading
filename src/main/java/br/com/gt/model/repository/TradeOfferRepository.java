package br.com.gt.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gt.model.bean.TradeOffer;
import br.com.gt.model.bean.Usr;

public interface TradeOfferRepository extends JpaRepository<TradeOffer, Long> {

	List<TradeOffer> findByBidder(Usr bidder);

}
