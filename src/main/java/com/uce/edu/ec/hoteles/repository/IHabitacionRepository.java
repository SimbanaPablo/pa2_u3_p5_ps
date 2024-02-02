package com.uce.edu.ec.hoteles.repository;

import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Habitacion;

public interface IHabitacionRepository {
	public List<Habitacion> seleccionarHabitacionInnerJoin(String nombreHotel);

	public List<Habitacion> seleccionarHabitacionLeftJoin(String direccion);

	public List<Habitacion> seleccionarHabitacionRightJoin(String conexionWifi);

	public List<Habitacion> seleccionarHabitacionFullJoin(String clase);

	public List<Habitacion> seleccionarHabitacionFetchJoin();

}
