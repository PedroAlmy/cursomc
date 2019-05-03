package com.udemy.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.repositories.ClienteRepository;
import com.udemy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorioCliente;
	
	public Cliente buscarPorId (Integer id) {
		Cliente cliente = repositorioCliente.findOne(id);
			if(cliente == null) {
				throw new ObjectNotFoundException("Objeto não encontrado, ID: " + id + " , Tipo: " + Cliente.class.getName());
			}
		return cliente;
	}
}
