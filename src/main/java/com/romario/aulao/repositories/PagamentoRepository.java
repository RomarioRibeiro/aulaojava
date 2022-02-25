package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.aulao.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento , Integer>  {
	@Query(value="select*from pagamento where id = ?",nativeQuery = true )
	Pagamento find(Integer id);
}
