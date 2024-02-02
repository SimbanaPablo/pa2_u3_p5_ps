package com.uce.edu.ec.hoteles.service;

import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Habitacion;

public interface IHabitacionService {
	public List<Habitacion> buscarrHabitacionInnerJoin(String nombreHotel);

	public List<Habitacion> buscarHabitacionLeftJoin(String direccion);

	public List<Habitacion> buscarHabitacionRightJoin(String conexionWifi);

	public List<Habitacion> buscarHabitacionFullJoin(String clase);

	public List<Habitacion> buscarHabitacionFetchJoin();
}
