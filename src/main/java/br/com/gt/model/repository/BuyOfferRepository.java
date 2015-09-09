package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.BuyOffer;

@Repository
public interface BuyOfferRepository extends JpaRepository<BuyOffer, Long> {

}
