package com.uce.edu.ec.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "123456";
		cedula = cedula + "provincia";
		return cedula;
	}


}
