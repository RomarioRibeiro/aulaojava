package com.romario.aulao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.romario.aulao.domain.Cliente;
import com.romario.aulao.domain.Pedido;

@Repository
public interface PedidoReposirory extends JpaRepository <Pedido , Integer>  {
	@Query(value="select*from pedido where id = ?",nativeQuery = true )
	Pedido find(Integer id);
	
	@Transactional(readOnly = true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
}
