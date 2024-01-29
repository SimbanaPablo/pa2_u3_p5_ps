package com.uce.edu.ec.hoteles.repository;

import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Hotel;

public interface IHotelRepository {
	public void insertar(Hotel hotel);

	public List<Hotel> seleccionarHotelInnerJoin(String nombre);

	public List<Hotel> seleccionarHotelRightJoin(String direccion);

	public List<Hotel> seleccionarHotelLeftJoin(String conexionWifi);

	public List<Hotel> seleccionarHotelFullJoin(String clase);
}
