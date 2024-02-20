package com.uce.edu.ec;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
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
		// this.facturaService.pruebaSupports();
		// this.facturaService.pruebaNever();
		/*
		 * System.out.println("Nombre hilo: "+Thread.currentThread().getName()); long
		 * tiempoInicial = System.currentTimeMillis(); for(int i=1;i<=10;i++) { Cliente
		 * cliente = new Cliente(); cliente.setNombre("CN"+i);
		 * cliente.setApellido("CA"+i); this.clienteService.guardar(cliente); } long
		 * tiempoFinal = System.currentTimeMillis();
		 * 
		 * long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		 * System.out.println("Tiempo transcurrido: "+tiempoTranscurrido); //Tiempo
		 * transcurrido en seg:101
		 */
		// Programcion en paralelo (multihilo - MultiThread)
//		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for (int i = 1; i <= 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaCliente.add(cliente);
//		}
//		listaCliente.stream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long tiempoFinal = System.currentTimeMillis();
//
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		System.out.println("Tiempo transcurrido: " + tiempoTranscurrido);
		// Tiempo transcurrido en seg:101
		
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente> listaCliente = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			listaCliente.add(cliente);
		}
		listaCliente.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido: " + tiempoTranscurrido);
		//Tiempo transcurrido en seg:25
	}

}
