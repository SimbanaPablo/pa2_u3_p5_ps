package com.uce.edu.ec.ventas.repository;

import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);

	public List<Factura> seleccionarFacturasInnerJoin();

	public List<Factura> seleccionarFacturasRightJoin();

	public List<Factura> seleccionarFacturasLeftJoin();

	public List<Factura> seleccionarFacturasFullJoin();

	public List<Factura> seleccionarFaturasWhereJoin();

	public List<Factura> seleccionarFaturasFetchJoin();

}
