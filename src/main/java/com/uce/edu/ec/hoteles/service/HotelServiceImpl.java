package com.uce.edu.ec.hoteles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.hoteles.repository.IHotelRepository;
import com.uce.edu.ec.ventas.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelInnerJoin(nombre);
	}

	@Override
	public List<Hotel> buscarHotelRightJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelRightJoin(direccion);
	}

	@Override
	public List<Hotel> buscarHotelLeftJoin(String conexionWifi) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelLeftJoin(conexionWifi);
	}

	@Override
	public List<Hotel> buscarHotelFullJoin(String clase) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelFullJoin(clase);
	}

}
