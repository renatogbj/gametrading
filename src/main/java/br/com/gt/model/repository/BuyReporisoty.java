package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Buy;

@Repository
public interface BuyReporisoty extends JpaRepository<Buy, Long> {

}
