package com.uce.edu.ec.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
//		for (Factura f : lista) {
//			f.getDetalleFactura().size();
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQ.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFactura d",
				Factura.class);
		List<Factura> lista = myQ.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFactura d",
				Factura.class);
		List<Factura> lista = myQ.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFaturasWhereJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> lista = myQ.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFaturasFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQ = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFactura d", Factura.class);
		return myQ.getResultList();
	}

	@Override
	public int actualizarFecha(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		Query myQ = this.entityManager
				.createQuery("UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha >=: fechaActual");
		myQ.setParameter("fechaNueva", fechaNueva);
		myQ.setParameter("fechaActual", fechaActual);
		return myQ.executeUpdate();
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Query myQ = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =:numero");
		myQ.setParameter("numero", numero);
		return myQ.executeUpdate();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	public Factura seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> myQ = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.ec.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f",
				FacturaDTO.class);
		return myQ.getResultList();
	}

}
