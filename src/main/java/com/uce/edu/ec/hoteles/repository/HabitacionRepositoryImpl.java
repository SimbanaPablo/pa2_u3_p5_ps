package com.uce.edu.ec.hoteles.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.ec.ventas.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Habitacion> seleccionarHabitacionInnerJoin(String nombreHotel) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQ = this.entityManager.createQuery(
				"SELECT h FROM Habitacion h INNER JOIN h.hotel WHERE h.hotel.nombre =:nombreHotel", Habitacion.class);
		myQ.setParameter("nombreHotel", nombreHotel);
		return myQ.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQ = this.entityManager.createQuery(
				"SELECT h FROM Habitacion h LEFT JOIN h.hotel WHERE h.hotel.direccion =:direccion", Habitacion.class);
		myQ.setParameter("direccion", direccion);
		return myQ.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionRightJoin(String conexionWifi) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQ = this.entityManager.createQuery(
				"SELECT h FROM Habitacion h RIGHT JOIN h.hotel WHERE h.hotel.conexionWifi =:conexionWifi",
				Habitacion.class);
		myQ.setParameter("conexionWifi", conexionWifi);
		return myQ.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionFullJoin(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQ = this.entityManager.createQuery(
				"SELECT h FROM Habitacion h FULL JOIN h.hotel WHERE h.clase =:clase", Habitacion.class);
		myQ.setParameter("clase", clase);
		return myQ.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQ = this.entityManager.createQuery("SELECT h FROM Habitacion h JOIN FETCH h.hotel",
				//"SELECT h FROM Hotel h JOIN FETCH f.habitaciones f"
				Habitacion.class);
		return myQ.getResultList();
	}

}
