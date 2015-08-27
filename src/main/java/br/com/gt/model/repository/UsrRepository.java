package br.com.gt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gt.model.bean.Usr;

@Repository
public interface UsrRepository extends JpaRepository<Usr, Long> {

	Usr findByEmail(String email);

}
