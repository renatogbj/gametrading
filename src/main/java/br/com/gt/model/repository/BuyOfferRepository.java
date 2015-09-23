package br.com.gt.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.BuyOffer;
import br.com.gt.model.bean.Usr;

@Repository
public interface BuyOfferRepository extends JpaRepository<BuyOffer, Long> {

	List<BuyOffer> findByBidder(Usr bidder);

}
