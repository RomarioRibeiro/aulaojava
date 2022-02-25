package com.romario.aulao.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.romario.aulao.domain.Categoria;
import com.romario.aulao.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto , Integer>  {
	@Query(value="select * from produto where id = ?",nativeQuery = true )
	Produto find(Integer id);
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn (String nome, List<Categoria>  categorias, Pageable pageRequest);
	
}
