package com.uce.edu.ec.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.ventas.repository.IClienteRepository;
import com.uce.edu.ec.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			this.clienteRepository.insertar(cliente);	
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
