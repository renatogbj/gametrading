package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.SellOfferAnswer;

@Repository
public interface SellOfferAnswerRepository extends JpaRepository<SellOfferAnswer, Long> {

}
