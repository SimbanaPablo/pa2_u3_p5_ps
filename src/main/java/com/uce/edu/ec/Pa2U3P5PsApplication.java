package com.uce.edu.ec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ec.hoteles.service.IHabitacionService;
import com.uce.edu.ec.hoteles.service.IHotelService;
import com.uce.edu.ec.ventas.repository.modelo.Habitacion;
import com.uce.edu.ec.ventas.repository.modelo.Hotel;
import com.uce.edu.ec.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5PsApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5PsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("\nINNER JOIN");
		List<Habitacion> listaHa = this.habitacionService.buscarrHabitacionInnerJoin("Hotel Finlandia");
		for(Habitacion h: listaHa) {
			System.out.println(h);
		}
		System.out.println("----------------------------------------");
		List<Hotel> listaHo = this.hotelService.buscarHotelInnerJoin("Hotel Finlandia");
		for(Hotel h: listaHo) {
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println(ha);
			}
		}
		
		System.out.println("\nLEFT JOIN");
		List<Habitacion> listaHa1 = this.habitacionService.buscarHabitacionLeftJoin("La Carolina, Quito");
		for(Habitacion h: listaHa1) {
			System.out.println(h);
		}
		System.out.println("----------------------------------------");
		List<Hotel> listaHo1 = this.hotelService.buscarHotelLeftJoin("true");
		for(Hotel h: listaHo1) {
			System.out.println(h.getConexionWifi());
		}
		
		System.out.println("\nRIGHT JOIN");
		List<Habitacion> listaHa2 = this.habitacionService.buscarHabitacionRightJoin("true");
		for(Habitacion h: listaHa2) {
			System.out.println(h);
		}
		System.out.println("----------------------------------------");
		List<Hotel> listaHo2 = this.hotelService.buscarHotelRightJoin("Centro Historico, Quito");
		for(Hotel h: listaHo2) {
			System.out.println(h.getDireccion());
		}
		
		System.out.println("\nFULL JOIN");
		List<Habitacion> listaHa3 = this.habitacionService.buscarHabitacionFullJoin("Suite");
		for(Habitacion h: listaHa3) {
			System.out.println(h);
		}
		System.out.println("----------------------------------------");
		List<Hotel> listaHo3 = this.hotelService.buscarHotelRightJoin("Centro Historico, Quito");
		for(Hotel h: listaHo3) {
			System.out.println(h.getDireccion());
		}
		
		System.out.println("\nFETCH JOIN");
		List<Habitacion> listaHa4 = this.habitacionService.buscarHabitacionFetchJoin();
		for(Habitacion h: listaHa4) {
			System.out.println(h);
		}
		System.out.println("----------------------------------------");
		List<Hotel> listaHo4 = this.hotelService.buscarHotelFetchJoin();
		for(Hotel h: listaHo4) {
			System.out.println(h.getNombre());
		}

		
		
	}
	
}
