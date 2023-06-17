package procesos;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Profesional extends Usuario {
	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional() {};
	public Profesional(String nombre, LocalDate fechaNacimiento, int run, String titulo, LocalDate fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		if(titulo.length() < 10 && titulo.length() > 50 )  throw new InputMismatchException("Entrada no valida, titulo: mínimo 10 caracteres, máximo 50 ");  
		this.titulo = titulo;
		// como validar dd/mm/aa
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String analizarUsuario() {
		return super.analizarUsuario() + " " + getTitulo() + " " + getFechaIngreso();
	}
}
