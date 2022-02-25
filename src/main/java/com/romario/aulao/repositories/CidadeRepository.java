package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.aulao.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade , Integer>  {
	@Query(value="select*from cidade where id = ?",nativeQuery = true )
	Cidade find(Integer id);
}
