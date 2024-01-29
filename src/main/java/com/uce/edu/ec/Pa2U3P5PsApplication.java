package com.uce.edu.ec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ec.hoteles.service.IHotelService;
import com.uce.edu.ec.ventas.repository.modelo.Habitacion;
import com.uce.edu.ec.ventas.repository.modelo.Hotel;
import com.uce.edu.ec.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5PsApplication implements CommandLineRunner {
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5PsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		Hotel hote1 = new Hotel();
//		hote1.setDireccion("La Carolina, Quito");
//		hote1.setNombre("Wyndham Garden Quito");
//		hote1.setConexionWifi("true");
//		
//		Habitacion habi1 = new Habitacion();
//		habi1.setClase("Suite");
//		habi1.setHotel(hote1);
//		habi1.setNumero("W01");
//		
//		Habitacion habi2 = new Habitacion();
//		habi2.setClase("Suite");
//		habi2.setHotel(hote1);
//		habi2.setNumero("W02");
//		
//		Habitacion habi3 = new Habitacion();
//		habi3.setClase("Suite");
//		habi3.setHotel(hote1);
//		habi3.setNumero("W03");
//		
//		List<Habitacion> listaHabi = new ArrayList<>();
//		listaHabi.add(habi1);
//		listaHabi.add(habi2);
//		listaHabi.add(habi3);
//		
//		hote1.setHabitaciones(listaHabi);
		
//		this.hotelService.guardar(hote1);
		
		
		System.out.println("\nINNER JOIN parametro nombre");

		List<Hotel> listaHotel1 = this.hotelService.buscarHotelInnerJoin("Hotel Finlandia");
		for (Hotel f : listaHotel1) {
			System.out.println(f.getHabitaciones());
		}

		System.out.println("\nRIGHT JOIN parametro direccion");

		List<Hotel> listaHotel2 = this.hotelService.buscarHotelRightJoin("La Carolina, Quito");
		for (Hotel f : listaHotel2) {
			System.out.println(f.getHabitaciones());
		}	

		System.out.println("\nLEFT JOIN parametro conexion wifi");

		List<Hotel> listaHotel3 = this.hotelService.buscarHotelLeftJoin("true");
		for (Hotel f : listaHotel3) {
			System.out.println(f.getHabitaciones());
		}
		
		System.out.println("\nFULL JOIN parametro clase de habitacion");

		List<Hotel> listaHotel4 = this.hotelService.buscarHotelFullJoin("Suite");
		for (Hotel f : listaHotel4) {
			System.out.println(f.getHabitaciones());
		}

	}

}
