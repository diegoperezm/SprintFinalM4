package procesos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitaTerreno {
	private int idVisita;
	private int rutCliente;
	private LocalDate dia;
	private String hora;
	private String lugar;
	private String comentarios;
	private static int idAuto = 0;

	public VisitaTerreno() {
	}

	public VisitaTerreno(int rutCliente, LocalDate dia, String hora, String lugar, String comentarios) {
		this.idVisita = ++idAuto;
		this.rutCliente = rutCliente;
		if (!validarFecha(dia))
			throw new InputMismatchException(
					"Entrada no valida, dia: debe ser ingresada como dd-mm-aaaa (ej: 01-05-2001)");
		this.dia = dia;
		if (!validarHora(hora))
			throw new IllegalArgumentException("Entrada invalida. Ingrese una hora con formato hh:mm (ej: 20:45)");
		this.hora = hora;
		if(lugar.length() < 10 || lugar.length() > 50) throw new IllegalArgumentException("Entrada invalida lugar: mínimo 10 caracteres, máximo 50");
		this.lugar = lugar;
		if(comentarios.length() > 100) throw new IllegalArgumentException("Entrada invalida, comentarios: máximo 100 caracteres");
		this.comentarios = comentarios;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "VisitaTerreno [idVisita=" + idVisita + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora=" + hora
				+ ", lugar=" + lugar + ", comentarios=" + comentarios + "]";
	};

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
	
	public boolean validarHora(String hora) {
		Pattern formatoHora = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
		Matcher matchHora = formatoHora.matcher(hora);
		return matchHora.find();
	}
}
