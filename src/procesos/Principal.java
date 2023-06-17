package procesos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {

	public static void agregarCliente(Scanner scan, Contenedor con) {
		System.out.println("INGRESE NOMBRE: ");
		String nombre = scan.nextLine();
		
		System.out.println("INGRESE FECHA (EJEMPLO 01-02-2002): ");
		String fecha = scan.nextLine();
		
		System.out.println("INGRESE RUN (DEBEN SER 8 DIGITOS): ");
		int run = scan.nextInt();
		scan.nextLine();
		
		System.out.println("INGRESE APELLIDOS: ");
		String apellidos = scan.nextLine();
		
		System.out.println("INGRESE NUMERO DE TELEFONO: ");
		int telefono = scan.nextInt();
		scan.nextLine();
		
		System.out.println("INGRESE AFP (INGRESE MINIMO 4 CARACTERES Y MAXIMO 30): ");
		String afp = scan.nextLine();
		
		System.out.println("INGRESE SISTEMA DE SALUD (SOLO PUEDE SER 1(FONASA) O 2(ISAPRE)): ");
		int salud = scan.nextInt();
		scan.nextLine();
		
		System.out.println("INGRESE DIRECCION (MAXIMO 70 CARACTERES): ");
		String direccion = scan.nextLine();
		
		System.out.println("INGRESE COMUNA (MAXIMO 50 CARACTERES): ");
		String comuna = scan.nextLine();
		
		System.out.println("INGRESE EDAD (MAYOR A 0 Y MENOR A 150): ");
		int edad = scan.nextInt();
		scan.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(fecha, formatter);
		
		Cliente cliente = new Cliente(nombre,localDate,run,apellidos,telefono,afp,salud,direccion,comuna,edad);
		con.almacenarCliente(cliente);
	}
	
	public static void agregarProfesional(Scanner scan, Contenedor con) {
				
		System.out.println("INGRESE NOMBRE: ");
		String nombre = scan.nextLine();
		
		System.out.println("INGRESE FECHA (EJEMPLO 01-02-2002): ");
		String fecha = scan.nextLine();
		
		System.out.println("INGRESE RUN (DEBEN SER 8 DIGITOS): ");
		int run = scan.nextInt();
		scan.nextLine();
		
		System.out.println("INGRESE TITULO PROFESIONAL (MINIMO 10 CARACTERES Y MAXIMO 50): ");
		String titulo = scan.nextLine();
		
		System.out.println("INGRESE FECHA DE INGRESO (EJEMPLO 01-02-2002): ");
		String fechaIngreso = scan.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(fecha, formatter);
		LocalDate localDate2 = LocalDate.parse(fechaIngreso, formatter);
		
		System.out.println(formatter.format(localDate)); // localdate  = año/mes/dia  formatter.format(localDate) = dia/mes/año
		
		Profesional profesional = new Profesional(nombre,localDate,run,titulo,localDate2);		
		con.almacenarProfesional(profesional);
	}
	
	public static void listarUsuarios(Scanner scan, Contenedor con) {
		System.out.println("");
	}
	
	public static void main(String[] args) {

		Contenedor contenedor = new Contenedor();
		Scanner leer = new Scanner(System.in);
		int opcion;
		
		/*
		Usuario user = new Usuario("Algo",LocalDate.now(),11111111);
		Cliente cliente = new Cliente();
		
		agregarProfesional(leer, contenedor);
		
		
		System.out.println(user + " " + user.formatoFecha(user.getFechaNacimiento()));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = "15-10-2018";
		LocalDate localDate = LocalDate.parse(date, formatter);

		System.out.println(localDate); 
		System.out.println(formatter.format(localDate));
		*/
		
		/*
		 * MENU 9 opciones 
		 * - 8 para las acciones indicadad en el listado anterior 
		 * - 1  para salir del programa 
		 * - opcion incorrecta debe reintentar
		*/
		
		System.out.println("------- MENU DE OPCIONES -------");
		System.out.println("   1. ALMACENAR CLIENTE         ");
		System.out.println("   2. ALMACENAR PROFESIONAL     ");
		System.out.println("   3. ALMACENAR ADMINISTRATIVO  ");
		System.out.println("   4. ALMACENAR CAPACITACION    ");
		System.out.println("   5. ELIMINAR USUARIO          ");
		System.out.println("   6. LISTAR USUARIOS           ");
		System.out.println("   7. LISTAR USUARIOS POR TIPO  ");
		System.out.println("   8. LISTAR CAPACITACIONES     ");
		System.out.println("   9. SALIR DEL PROGRAMA        ");
		System.out.println("--------------------------------");
		System.out.println(" DIGITE UNA OPCION: ");
		opcion = leer.nextInt();
		leer.nextLine();
		
		switch(opcion) {
			case 1:
				agregarProfesional(leer, contenedor);
				break;
			
		}
		
		contenedor.listarUsuarios();

		/*
		System.out.println("INGRESE NOMBRE DEL CLIENTE: ");
		cliente.setNombre(leer.nextLine()); // HAY QUE VALIDAR ESTO
		
		System.out.println("INGRESE FECHA DE NACIMIENTO: ");
		cliente.setFechaNacimiento(leer.nextLine());
		
		System.out.println("INGRESE RUN: ");
		cliente.setRun(leer.nextInt());
		leer.nextLine(); //consume salto de linea
		
		System.out.println("INGRESE APELLIDOS: ");
		cliente.setApellidos(leer.nextLine());
		
		System.out.println("INGRESE TELEFONO DE CONTACTO: ");
		cliente.setTelefono(leer.nextInt());
		leer.nextLine();
		*/
		
	}




























































































































































































	
public static void agregarAdministrativo(Scanner scan, Contenedor con) {
		System.out.println("INGRESE NOMBRE: ");
		String nombre = scan.nextLine();
		
		System.out.println("INGRESE FECHA NACIMIENTO (EJEMPLO 01-02-2002): ");
		String fecha = scan.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(fecha, formatter);
		
		System.out.println("INGRESE RUN (DEBEN SER 8 DIGITOS): ");
		int run = scan.nextInt();
		scan.nextLine();
		
		System.out.println("INGRESE AREA: ");
		String area = scan.nextLine();
		
		System.out.println("INGRESE EXPERIENCIA PREVIA: ");
		String experienciaPrev = scan.nextLine();
	
        Administrativo administrativo = new Administrativo(nombre, fechaNacimiento, run,  area, experienciaPrev);
        
        con.almacenarAdministrativo(administrativo);

}

	public static void agregarCapacitacion(Scanner scan, Contenedor con) {
	    System.out.println("INGRESE IDENTIFICADOR: ");
		int identificador = scan.nextInt();
		scan.nextLine();

	    System.out.println("INGRESE RUT CLIENTE: ");
		int rutCliente = scan.nextInt();
		scan.nextLine();

		System.out.println("INGRESE DIA: ");
		String dia = scan.nextLine();

		System.out.println("INGRESE HORA: ");
		String hora = scan.nextLine();
		
		System.out.println("INGRESE LUGAR: ");
		String lugar = scan.nextLine();

		System.out.println("INGRESE DURACION: ");
		String duracion = scan.nextLine();
	
	    System.out.println("INGRESE CANTIDAD DE ASISTENTES: ");
		int cantidadAsistentes = scan.nextInt();
		scan.nextLine();

        Capacitacion capacitacion = new Capacitacion(identificador, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);
	   
        con.almacenarCapacitacion(capacitacion);
		
}	
	
	
}