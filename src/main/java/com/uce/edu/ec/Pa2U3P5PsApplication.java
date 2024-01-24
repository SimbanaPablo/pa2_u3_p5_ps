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
//		fact.setCedula("1723344556");
//		fact.setFecha(LocalDateTime.now());
//		fact.setNumero("0001-02569");
//
//		DetalleFactura det1 = new DetalleFactura();
//		det1.setCantidad(1);
//		det1.setCodigoBarras("6767456234");
//		det1.setFactura(fact);
//		det1.setNombreProducto("Sprite");
//		
//		DetalleFactura det2 = new DetalleFactura();
//		det2.setCantidad(3);
//		det2.setCodigoBarras("9823367538");
//		det2.setFactura(fact);
//		det2.setNombreProducto("Galleta");
//		
//		List<DetalleFactura> listaDetalle = new ArrayList<>();
//		listaDetalle.add(det1);
//		listaDetalle.add(det2);
//		
//		fact.setDetalleFactura(listaDetalle);
//		this.facturaService.guardar(fact);

		Factura factBusqueda = this.facturaService.buscarPorNumero("0001-02569");
		System.out.println(factBusqueda);
		for(DetalleFactura d: factBusqueda.getDetalleFactura()) {
			System.out.println(d.getNombreProducto());
		}
		
		

	}

}
