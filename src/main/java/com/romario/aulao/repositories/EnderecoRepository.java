package com.romario.aulao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.aulao.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco , Integer>  {
	@Query(value="select*from endereco where id = ?",nativeQuery = true )
	Endereco find(Integer id);
}
