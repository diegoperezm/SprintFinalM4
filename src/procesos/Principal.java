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

		System.out.println("INGRESE NUMERO DE TELEFONO (MAXIMO 10 NUMEROS): ");
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

		Cliente cliente = new Cliente(nombre, localDate, run, apellidos, telefono, afp, salud, direccion, comuna, edad);
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

		Profesional profesional = new Profesional(nombre, localDate, run, titulo, localDate2);
		con.almacenarProfesional(profesional);
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

		Administrativo administrativo = new Administrativo(nombre, fechaNacimiento, run, area, experienciaPrev);

		con.almacenarAdministrativo(administrativo);

	}

	public static void agregarCapacitacion(Scanner scan, Contenedor con) {

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

		Capacitacion capacitacion = new Capacitacion(rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);

		con.almacenarCapacitacion(capacitacion);

	}

	public static void eliminarUsuarioPorRun(Scanner scan, Contenedor con) {
		System.out.println("INGRESE RUN DEL USUARIO A ELIMINAR: ");
		int run = scan.nextInt();
		scan.nextLine();
		con.eliminarUsuario(run);
	}

	public static void listarUsuarioTipo(Scanner scan, Contenedor con) {
		int opcion;

		System.out.println("------- SELECCIONE TIPO DE USUARIO  -------");
		System.out.println("   1.  CLIENTE         ");
		System.out.println("   2.  PROFESIONAL     ");
		System.out.println("   3.  ADMINISTRATIVO  ");

		opcion = scan.nextInt();
		scan.nextLine();

		while (opcion < 1 || opcion > 3) {
			System.out.println("------- SELECCIONE TIPO DE USUARIO  -------");
			System.out.println("   1.  CLIENTE         ");
			System.out.println("   2.  PROFESIONAL     ");
			System.out.println("   3.  ADMINISTRATIVO  ");
			opcion = scan.nextInt();
			scan.nextLine();

		}
		switch (opcion) {
		case 1:
			System.out.println("   LISTA DE  CLIENTES:");
			con.listarUsuariosPorTipo(new Cliente());
			break;
		case 2:
			System.out.println("   LISTA DE  PROFESIONALES:");
			con.listarUsuariosPorTipo(new Profesional());
			break;
		case 3:
			System.out.println("   LISTA DE  ADMINISTRATIVOS:");
			con.listarUsuariosPorTipo(new Administrativo());
			break;
		}
	}

	public static void listarUsuarios(Contenedor con) {
		System.out.println("------- LISTA DE USUARIOS -------");
		con.listarUsuarios();
	}

	public static void listarCapacitaciones(Contenedor con) {
		System.out.println("------- LISTA DE CAPACITACIONES -------");
		con.listarCapacitaciones();
	}

	public static void clearTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void main(String[] args) {

		Contenedor contenedor = new Contenedor();
		Scanner leer = new Scanner(System.in);
		int opcion;

	
		Profesional pro = new Profesional("algo", LocalDate.of(2002, 05, 20), 12345678, "aaaaaaaaaaa",
				LocalDate.of(2002, 05, 20));
		contenedor.almacenarProfesional(pro);
		Capacitacion cap = new Capacitacion(12345678, "lunes", "20:05", "aaaaaaaaaa", "duracion", 25);
		contenedor.almacenarCapacitacion(cap);
		
		do {

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

			while (opcion < 1 || opcion > 9) {
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
			}

			switch (opcion) {
			case 1:
				agregarCliente(leer, contenedor);
				break;
			case 2:
				agregarProfesional(leer, contenedor);
				break;
			case 3:
				agregarAdministrativo(leer, contenedor);
				break;
			case 4:
				agregarCapacitacion(leer, contenedor);
				break;
			case 5:
				eliminarUsuarioPorRun(leer, contenedor);
				break;
			case 6:
				listarUsuarios(contenedor);
				break;
			case 7:
				listarUsuarioTipo(leer, contenedor);
				break;
			case 8:
				listarCapacitaciones(contenedor);
				break;
			case 9:
				clearTerminal();
				System.out.println("HAS SALIDO DEL PROGRAMA. HASTA LUEGO!");
				System.exit(0);
				break;
			}
		} while (opcion != 9);
		leer.close();
	}

}