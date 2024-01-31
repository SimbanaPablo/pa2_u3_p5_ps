package com.uce.edu.ec.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);

	public List<Factura> seleccionarFacturasInnerJoin();

	public List<Factura> seleccionarFacturasRightJoin();

	public List<Factura> seleccionarFacturasLeftJoin();

	public List<Factura> seleccionarFacturasFullJoin();

	public List<Factura> seleccionarFaturasWhereJoin();

	public List<Factura> seleccionarFaturasFetchJoin();

	public int actualizarFecha(LocalDateTime fechaNueva, LocalDateTime fechaActual);

	public int eliminarPorNumero(String numero);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public List<FacturaDTO> seleccionarFacturasDTO();

}
