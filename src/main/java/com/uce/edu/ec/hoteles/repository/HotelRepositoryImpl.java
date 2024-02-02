package com.uce.edu.ec.hoteles.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public List<Hotel> seleccionarHotelInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.entityManager
				.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones b WHERE h.nombre =:nombre", Hotel.class);
		myQ.setParameter("nombre", nombre);
		List<Hotel> lista = myQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelRightJoin(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones b WHERE h.direccion =:direccion", Hotel.class);
		myQ.setParameter("direccion", direccion);
		List<Hotel> lista = myQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelLeftJoin(String conexionWifi) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones b WHERE h.conexionWifi =:conexionWifi", Hotel.class);
		myQ.setParameter("conexionWifi", conexionWifi);
		List<Hotel> lista = myQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelFullJoin(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.entityManager
				.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones b WHERE b.clase =:clase", Hotel.class);
		myQ.setParameter("clase", clase);
		List<Hotel> lista = myQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQ = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones f",
				Hotel.class);
		return myQ.getResultList();
	}

}
