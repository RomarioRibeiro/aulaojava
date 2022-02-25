package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.aulao.domain.Pedido;

@Repository
public interface PedidoReposirory extends JpaRepository <Pedido , Integer>  {
	@Query(value="select*from pedido where id = ?",nativeQuery = true )
	Pedido find(Integer id);
}
