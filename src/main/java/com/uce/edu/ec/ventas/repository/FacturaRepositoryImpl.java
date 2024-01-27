package com.uce.edu.ec.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uce.edu.ec.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> tq = this.entityManager.createQuery("SELECT l FROM Factura l WHERE l.numero =:numero",
				Factura.class);
		tq.setParameter("numero", numero);
		Factura fact = tq.getSingleResult();
		fact.getDetalleFactura().size();
		return fact;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQ.getResultList();
		for(Factura f: lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQ.getResultList();
		for(Factura f: lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQ.getResultList();
		for(Factura f: lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQ.getResultList();
		for(Factura f: lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

}
