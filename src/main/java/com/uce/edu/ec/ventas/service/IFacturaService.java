package com.uce.edu.ec.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura);

	public List<Factura> buscarFacturasInnerJoin();

	public List<Factura> buscarFacturasRightJoin();

	public List<Factura> buscarFacturasLeftJoin();

	public List<Factura> buscarFacturasFullJoin();

	public List<Factura> buscarFaturasWhereJoin();

	public List<Factura> buscarFaturasFetchJoin();

	public int actualizarFecha(LocalDateTime fechaNueva, LocalDateTime fechaActual);

	public int borrarPorNumero(String numero);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public List<FacturaDTO> buscarFacturasDTO();
}
