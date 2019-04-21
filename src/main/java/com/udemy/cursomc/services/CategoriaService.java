package com.udemy.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;
	
	public Categoria buscarPeloId(Integer id) {
		
		Categoria obj = repositorio.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado ! Id: " + id 
					+ ", Tipo: " + Categoria.class.getName());
			
		}
		return obj;
	}
}

