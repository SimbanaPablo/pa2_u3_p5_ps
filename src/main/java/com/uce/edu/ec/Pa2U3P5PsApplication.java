package com.uce.edu.ec;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ec.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ec.ventas.repository.modelo.Factura;
import com.uce.edu.ec.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5PsApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5PsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		Factura fact = new Factura();
//		fact.setCedula("1723344552");
//		fact.setFecha(LocalDateTime.now());
//		fact.setNumero("0001-34512");
//
//		DetalleFactura det1 = new DetalleFactura();
//		det1.setCantidad(1);
//		det1.setCodigoBarras("87034566745");
//		det1.setFactura(fact);
//		det1.setNombreProducto("Fideo");
//		
//		DetalleFactura det2 = new DetalleFactura();
//		det2.setCantidad(3);
//		det2.setCodigoBarras("1234321267");
//		det2.setFactura(fact);
//		det2.setNombreProducto("Mayonesa");
//		
//		DetalleFactura det3 = new DetalleFactura();
//		det3.setCantidad(1);
//		det3.setCodigoBarras("956783412");
//		det3.setFactura(fact);
//		det3.setNombreProducto("Canguil");
//		
//		List<DetalleFactura> listaDetalle = new ArrayList<>();
//		listaDetalle.add(det1);
//		listaDetalle.add(det2);
//		listaDetalle.add(det3);
//		
//		fact.setDetalleFactura(listaDetalle);
//		this.facturaService.guardar(fact);

		System.out.println("\nINNER JOIN");

		List<Factura> listaFactura = this.facturaService.buscarFacturasInnerJoin();
		for (Factura f : listaFactura) {
			System.out.println(f);
		}

		System.out.println("\nRIGHT JOIN");

		List<Factura> listaFactura2 = this.facturaService.buscarFacturasRightJoin();
		for (Factura f : listaFactura2) {
			System.out.println(f.getNumero());
		}

		System.out.println("\nLEFT JOIN");

		List<Factura> listaFactura3 = this.facturaService.buscarFacturasLeftJoin();
		for (Factura f : listaFactura3) {
			System.out.println(f);
		}
		
		System.out.println("\nFULL JOIN");

		List<Factura> listaFactura4 = this.facturaService.buscarFacturasFullJoin();
		for (Factura f : listaFactura4) {
			System.out.println(f);
			for(DetalleFactura d: f.getDetalleFactura()) {
				System.out.println(d);
			}
		}

	}

}
