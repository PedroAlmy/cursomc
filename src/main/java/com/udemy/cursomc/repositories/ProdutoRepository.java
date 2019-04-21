package com.udemy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	
}
