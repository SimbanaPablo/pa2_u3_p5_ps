package com.uce.edu.ec.hoteles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.hoteles.repository.IHabitacionRepository;
import com.uce.edu.ec.ventas.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public List<Habitacion> buscarrHabitacionInnerJoin(String nombreHotel) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarHabitacionInnerJoin(nombreHotel);
	}

	@Override
	public List<Habitacion> buscarHabitacionLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarHabitacionLeftJoin(direccion);
	}

	@Override
	public List<Habitacion> buscarHabitacionRightJoin(String conexionWifi) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarHabitacionRightJoin(conexionWifi);
	}

	@Override
	public List<Habitacion> buscarHabitacionFullJoin(String clase) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarHabitacionFullJoin(clase);
	}

	@Override
	public List<Habitacion> buscarHabitacionFetchJoin() {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarHabitacionFetchJoin();
	}

}
