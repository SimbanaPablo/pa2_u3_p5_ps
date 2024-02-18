package com.uce.edu.ec.funcional;

public class MetodosReferenciados {
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "123456";
		cedula = cedula + "referenciado";
		return cedula;
	}

	public void procesar(String arg) {
		// TODO Auto-generated method stub
		System.out.println("Se inserta ");
		System.out.println(arg);
	}

	public boolean evaluar(String cadena) {
		return "Pablo".contains(cadena);
	}

	public boolean evaluar(Integer numero) {
		return 8 == numero;
	}

	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre(empl.getNombreCompleto().split(" ")[0]);
		ciud.setApellido(empl.getNombreCompleto().split(" ")[1]);
		ciud.setProvincia("Chimborazo");
		return ciud;
	}

	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto() + " " + empl.getPais());
		empl.setPais(empl.getPais() + " de nacimiento");
		return empl;
	}

}
