package com.udemy.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.domain.Endereco;
import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.domain.Pagamento;
import com.udemy.cursomc.domain.PagamentoComBoleto;
import com.udemy.cursomc.domain.PagamentoComCartao;
import com.udemy.cursomc.domain.Pedido;
import com.udemy.cursomc.domain.Produto;
import com.udemy.cursomc.domain.enums.EstadoPagamento;
import com.udemy.cursomc.domain.enums.TipoCliente;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.repositories.CidadeRepository;
import com.udemy.cursomc.repositories.ClienteRepository;
import com.udemy.cursomc.repositories.EnderecoRepository;
import com.udemy.cursomc.repositories.EstadoRepository;
import com.udemy.cursomc.repositories.PagamentoRepository;
import com.udemy.cursomc.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository repositorioCliente;
	@Autowired 
	private EnderecoRepository repositorioEndereco;	
	@Autowired
	private PedidoRepository repositorioPedido;
	@Autowired 
	private PagamentoRepository repositorioPagamento;
	
	
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
		
	
		Cliente cliente1 = new Cliente(null, "Maria silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco endereco1 = new Endereco (null, "Rua flores", 300, "Apto 203", "Jardim", "328220834", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida matos", 105, "Sala 800", "Centro", "38777012", cliente1, cidade2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		repositorioCliente.save(Arrays.asList(cliente1));
		repositorioEndereco.save(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido (null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido ped2 = new Pedido (null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/2010/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cliente1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		repositorioPedido.save(Arrays.asList(ped1, ped2));
		repositorioPagamento.save(Arrays.asList(pagto1, pagto2));
	}

}
