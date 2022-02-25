package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.aulao.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository <ItemPedido , Integer>  {
	@Query(value="select*from itempedido where id = ?",nativeQuery = true )
	ItemPedido find(Integer id);
}
