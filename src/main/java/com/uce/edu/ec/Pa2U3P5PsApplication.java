package com.uce.edu.ec;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ec.hoteles.service.IHabitacionService;
import com.uce.edu.ec.hoteles.service.IHotelService;
import com.uce.edu.ec.ventas.repository.modelo.Cliente;
import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.service.IClienteService;
import com.uce.edu.ec.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5PsApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IHabitacionService habitacionService;

	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5PsApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		Factura fact = new Factura();
		fact.setCedula("12367");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("121213");

		Cliente cl = new Cliente();
		cl.setApellido("Pulupa");
		cl.setNombre("Fernando");
//		this.facturaService.guardar(fact, cl);
		
		this.facturaService.prueba();
		System.out.println("Main "+TransactionSynchronizationManager.isActualTransactionActive());

	}

}
