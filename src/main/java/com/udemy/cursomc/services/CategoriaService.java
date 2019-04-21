package com.udemy.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorioCategoria;
	
	public Categoria buscarPeloId(Integer id) {
		
		Categoria obj = repositorioCategoria.findOne(id);
		return obj;
	}
}

/* Metódos de buscas do springboot da versão 2 para frente.
 * 
 * public Categoria find(IntegerID) {
 * 
 * 		Optional <Categoria> obj = repo.findById(id);
 * 		return obj.orElse(null);
 * }
 * 
 * No exemplo está buscando por ID, mas pode ser usado por outros atributos.
 * */
 