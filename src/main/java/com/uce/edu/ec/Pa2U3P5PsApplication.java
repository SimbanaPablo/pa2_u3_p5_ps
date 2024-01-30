package com.uce.edu.ec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ec.hoteles.service.IHotelService;
import com.uce.edu.ec.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ec.ventas.repository.modelo.Factura;
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

		System.out.println("\nINNER JOIN");

		List<Factura> listaFacturas1 = this.facturaService.buscarFacturasInnerJoin();
		for (Factura f : listaFacturas1) {
			System.out.println(f.getNumero());
//			for(DetalleFactura detalle: f.getDetalleFactura()) {
//				System.out.println(detalle.getNombreProducto());
//			}
		}
		
		
		System.out.println("\nWHERE JOIN");

		List<Factura> listaFacturas2 = this.facturaService.buscarFaturasWhereJoin();
		for (Factura f : listaFacturas2) {
			System.out.println(f.getNumero());
			for(DetalleFactura detalle: f.getDetalleFactura()) {
				System.out.println(detalle.getNombreProducto());
			}
		}
		
		System.out.println("\nJOIN FETCH");

		List<Factura> listaFacturas3 = this.facturaService.buscarFaturasFetchJoin();
		for (Factura f : listaFacturas3) {
			System.out.println(f.getNumero());
			for(DetalleFactura detalle: f.getDetalleFactura()) {
				System.out.println(detalle.getNombreProducto());
			}
		}

	}

}
