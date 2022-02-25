package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.aulao.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado , Integer>  {
	@Query(value="select*from estado where id = ?",nativeQuery = true )
	Estado find(Integer id);
}
