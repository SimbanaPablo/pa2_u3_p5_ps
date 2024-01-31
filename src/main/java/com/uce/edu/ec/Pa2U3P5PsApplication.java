package com.uce.edu.ec;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ec.hoteles.service.IHotelService;
import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ec.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5PsApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5PsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("\nUPDATE");

		int cantidad = this.facturaService.actualizarFecha(LocalDateTime.of(2020,01, 15, 12, 50),LocalDateTime.of(2024,01,25,10,10)); //2024-01-26 19:24:19.010822
		System.out.println(cantidad);
		
		System.out.println("\nDELETE");
		int cantidad2 = this.facturaService.borrarPorNumero("0001-67888");
		System.out.println(cantidad2);

//		this.facturaService.eliminar(1);
		
		System.out.println("\nDTO");
		List<FacturaDTO> listaDTO = this.facturaService.buscarFacturasDTO();
		for(FacturaDTO f: listaDTO){
			System.out.println(f);
		}
		
	}
	
}
