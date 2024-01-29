package com.uce.edu.ec.hoteles.service;

import java.util.List;

import com.uce.edu.ec.ventas.repository.modelo.Hotel;

public interface IHotelService {
	public void guardar(Hotel hotel);

	public List<Hotel> buscarHotelInnerJoin(String nombre);

	public List<Hotel> buscarHotelRightJoin(String direccion);

	public List<Hotel> buscarHotelLeftJoin(String conexionWifi);

	public List<Hotel> buscarHotelFullJoin(String clase);
}
