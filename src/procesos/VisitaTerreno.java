package procesos;

import java.time.LocalDate;

public class VisitaTerreno {
	private int idVisita;
	private LocalDate dia;
	private LocalDate hora;
	private String lugar;
	private String comentarios;

	public VisitaTerreno() {
	}

	public VisitaTerreno(int idVisita, LocalDate dia, LocalDate hora, String lugar, String comentarios) {
		// como validar 
		this.idVisita = idVisita;
		// como validar dd/mm/aa
		this.dia = dia;
		// como validar HH:MM (hora desde 0 a 23, minutos entre 0 y 59)
		this.hora = hora;
		if(lugar.length() < 10 && lugar.length() > 50) throw new IllegalArgumentException("Entrada invalida lugar: mínimo 10 caracteres, máximo 50");
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

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
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
	};

}
