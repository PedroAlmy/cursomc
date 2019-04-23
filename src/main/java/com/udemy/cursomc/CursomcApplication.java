package com.udemy.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.domain.Produto;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.repositories.CidadeRepository;
import com.udemy.cursomc.repositories.EstadoRepository;
import com.udemy.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repositorioCategoria;
	@Autowired 
	private ProdutoRepository repositorioProduto; 
	@Autowired
	private EstadoRepository repositorioEstado;
	@Autowired 
	private CidadeRepository repositorioCidade;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	
		
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria (null, "Informatica");
		Categoria categoria2 = new Categoria (null, "Escritorio");
		
		Produto produto1 = new Produto (null, "Computador", 2000.00);
		Produto produto2 = new Produto (null, "Impressora", 800.00);
		Produto produto3 = new Produto (null, "Mouse", 80.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		Estado estado1 = new Estado (null, "São Paulo");
		Estado estado2 = new Estado (null, "Minas Gerais");
		
		Cidade cidade1 = new Cidade (null, "Uberlandia", estado2);
		Cidade cidade2 = new Cidade (null, "Campinas", estado1);
		Cidade cidade3 = new Cidade (null,"São Paulo", estado1);
		
		estado1.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		estado2.getCidades().addAll(Arrays.asList(cidade1));
		
		
		repositorioCategoria.save(Arrays.asList(categoria1, categoria2));
		repositorioProduto.save(Arrays.asList(produto1, produto2, produto3));
		repositorioEstado.save(Arrays.asList(estado1, estado2));
		repositorioCidade.save(Arrays.asList(cidade1, cidade2, cidade3));
		
	
	}

}
