package com.uce.edu.ec.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		System.out.println("*****************SUPPLIER");
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());
		// Lambdas
		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "123456";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());
		
		IPersonaSupplier<String> supplierLambda2 = () -> "123456"+"pais";
		System.out.println(supplierLambda2.getId());
		
		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		//Metodos referenciados
		System.out.println("Metodos referenciados");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4=met::obtenerId;
		System.out.println(supplierLambda4.getId());
		
		//2. Consumer
		System.out.println("*****************CONSUMER");
		//Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		//Lambdas
		System.out.println("Lambdas");
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta ");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		//Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaConsumer<String> consummer2=met::procesar;
		consummer2.accept("Pablo Referenciado");
		
		//3. Predicate
		System.out.println("*****************PREDICATE");
		//Lambdas
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		IPersonaPredicate<String> predicateLambda2 = letra -> "Pablo".contains(letra);
		System.out.println(predicateLambda2.evaluar("ab"));
		//Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaPredicate<String> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar("blo"));
		
		IPersonaPredicate<Integer> predicate3=met::evaluar;
		System.out.println(predicate3.evaluar(8));
		
		//4. Function
		System.out.println("*****************FUNCTION");
		//Lambdas
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero+Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(100));
		
		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano ->{
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());
			if(ciudadano.getProvincia().compareTo("Pichincha")==0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};
		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Simbaña");
		ciud.setNombre("Pablo");
		ciud.setProvincia("Pichincha");
		Empleado empl = functionLambda1.aplicar(ciud);
		System.out.println(empl);
		//Metodos Referenciados
		System.out.println("Metodos Referenciados");
		IPersonaFunction<Ciudadano, Empleado> function2=met::cambiar;
		Empleado empl1 = new Empleado();
		empl1.setNombreCompleto("Fernando Pulupa");
		empl1.setPais("Ecuador");
		Ciudadano ciud1 = function2.aplicar(empl1);
		System.out.println(ciud1);
		
		//5. Unary Operator
		System.out.println("*****************UNARY OPERATOR");
		//Lambdas
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda.aplicar(14));
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda1 = numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda1.aplicar(14));
		//Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaUnaryOperatorFunction<Empleado> unary3=met::procesar;
		Empleado empl3 = unary3.aplicar(empl1);
		System.out.println(empl3);
	
	}

}
