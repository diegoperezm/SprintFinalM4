package procesos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profesional extends Usuario {
	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional() {
	};

	public Profesional(String nombre, LocalDate fechaNacimiento, int run, String titulo, LocalDate fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		if (titulo.length() < 10 || titulo.length() > 50)
			throw new InputMismatchException("Entrada no valida, titulo: mínimo 10 caracteres, máximo 50 ");
		this.titulo = titulo;
		if (!validarFecha(fechaIngreso))
			throw new InputMismatchException(
					"Entrada no valida, fechaNacimiento: debe ser ingresada como dd-mm-aaaa (ej: 01-05-2001)");
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
	public String toString() {
		return "Profesional [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}

	@Override
	public String analizarUsuario() {
		return super.analizarUsuario() + " " + this.toString();
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
