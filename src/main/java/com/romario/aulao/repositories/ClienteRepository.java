package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.romario.aulao.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente , Integer>  {
	@Query(value="select * from  cliente where id = ?",nativeQuery = true )
	Cliente find(Integer id);
	
	@Transactional(readOnly = true)
	Cliente findByEmail (String email);
}
