package procesos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accidente {
	private int idAccidente;
	private LocalDate dia;
	private String hora;
	private String lugar;
	private String origen;
	private String consecuencias;
	private static int idAuto = 0;

	public Accidente() {
	}

	public Accidente(LocalDate dia, String hora, String lugar, String origen, String consecuencias) {
		this.idAccidente = ++idAuto;
		if (!validarFecha(dia))
			throw new InputMismatchException(
					"Entrada no valida, dia: debe ser ingresada como dd-mm-aaaa (ej: 01-05-2001)");
		this.dia = dia;
		if (!validarHora(hora))
			throw new IllegalArgumentException("Entrada invalida. Ingrese una hora con formato hh:mm (ej: 20:45)");
		this.hora = hora;
		if (lugar.length() < 10 && lugar.length() > 50)
			throw new InputMismatchException("Entrada no valida, lugar: mínimo 10 caracteres, máximo 50 caracteres");
		this.lugar = lugar;
		if (origen.length() > 100)
			throw new InputMismatchException("Entrada no valida, origen: máximo 100 caracteres");
		this.origen = origen;
		if (consecuencias.length() > 100)
			throw new InputMismatchException("Entrada no valida, consecuencias: máximo 100 caracteres");
		this.consecuencias = consecuencias;
	}

	public int getIdAccidente() {
		return idAccidente;
	}

	public void setIdAccidente(int idAccidente) {
		this.idAccidente = idAccidente;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getConsecuencias() {
		return consecuencias;
	}

	public void setConsecuencias(String consecuencias) {
		this.consecuencias = consecuencias;
	}

	@Override
	public String toString() {
		return "Accidente [idAccidente=" + idAccidente + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar
				+ ", origen=" + origen + ", consecuencias=" + consecuencias + "]";
	};

	public boolean validarHora(String hora) {
		Pattern formatoHora = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
		Matcher matchHora = formatoHora.matcher(hora);
		return matchHora.find();
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
