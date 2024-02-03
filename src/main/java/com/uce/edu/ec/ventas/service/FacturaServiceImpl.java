package com.uce.edu.ec.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ec.ventas.repository.IFacturaRepository;
import com.uce.edu.ec.ventas.repository.modelo.Cliente;
import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IClienteService clienteService;

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaRepository.insertar(factura);
		System.out.println("paso el insert de factura");
		this.clienteService.guardar(cliente);
		System.out.println("Paso el insert de cliente");
	}

	@Override
	public List<Factura> buscarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturasRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasRightJoin();
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturasFullJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasFullJoin();
	}

	@Override
	public List<Factura> buscarFaturasWhereJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFaturasWhereJoin();
	}

	@Override
	public List<Factura> buscarFaturasFetchJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFaturasFetchJoin();
	}

	@Override
	public int actualizarFecha(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.facturaRepository.actualizarFecha(fechaNueva, fechaActual);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepository.eliminar(id);
	}

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasDTO();
	}

}
