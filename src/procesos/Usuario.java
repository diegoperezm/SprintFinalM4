package procesos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

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
		// como validar dd/mm/aa ???
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
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + formatoFecha(fechaNacimiento) + ", run=" + run + "]";
	}

	@Override
	public String analizarUsuario() {
		return "Nombre: " +   getNombre() + " RUN: " + getRun();
	}
	
	public String formatoFecha(LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormateada = fecha.format(formatter);
		
		return fechaFormateada;
	}
	
	
}
