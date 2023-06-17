package procesos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario implements Asesoria {
	String nombre;
	LocalDate fechaNacimiento;
	int run;

	public Usuario() {
	};

	public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
		if (nombre.length() < 10 && nombre.length() > 50)
			throw new InputMismatchException("Entrada no valida, nombre: mínimo 10 caracteres, máximo 50 ");
		this.nombre = nombre;
		if (!validarFecha(fechaNacimiento))
			throw new InputMismatchException(
					"Entrada no valida, fechaNacimiento: debe ser ingresada como dd-mm-aaaa (ej: 01-05-2001 y mayor al año 1600)");
		this.fechaNacimiento = fechaNacimiento;
		if (run > 99999999)
			throw new InputMismatchException("Entrada no valida, run: debe ser menor a 99.999.999");
		this.run = run;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String mostrarEdad() {
		int edad = Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
		return String.format("El usuario tiene %d años", edad);
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + formatoFecha(fechaNacimiento) + ", run=" + run
				+ "]";
	}

	@Override
	public String analizarUsuario() {
		return "Nombre: " + getNombre() + " RUN: " + getRun();
	}

	public String formatoFecha(LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormateada = fecha.format(formatter);

		return fechaFormateada;
	}

	public boolean validarFecha(LocalDate fecha) {

		// pasamos el LocalDate a String
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormateada = fecha.format(formatter);

		// validamos que cumpla con la expresion regular dd.mm.YYY o dd/mm/YYYY o
		// dd-mm-YYYY
		Pattern formatoFecha = Pattern.compile(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		Matcher matchFecha = formatoFecha.matcher(fechaFormateada);
		return matchFecha.find();

	}
}
