package com.udemy.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursomc.domain.Categoria;

@RestController
@RequestMapping (value= "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar () {
		
		Categoria categoriaInformatica = new Categoria (1, "Informatica");
		Categoria categoriaEscritorio = new Categoria (2, "Escritorio");
		
		List <Categoria> listaDeCategoria = new ArrayList <>();
		
		listaDeCategoria.add(categoriaInformatica);
		listaDeCategoria.add(categoriaEscritorio);
		
		
		return listaDeCategoria;
		
	}
	

}
