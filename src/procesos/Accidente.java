package procesos;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Accidente {
	private int idAccidente;
	private LocalDate dia;
	private LocalDate hora;
	private String lugar;
	private String origen;
	private String consecuencias;

	public Accidente() {
	}

	public Accidente(int idAccidente, LocalDate dia, LocalDate hora, String lugar, String origen,
			String consecuencias) {
		// como validar ??
		this.idAccidente = idAccidente;
		// validar formato dd/mm/aa
		this.dia = dia;
		// validar formato HH:MM (hora desde 0 a 23 , minutos 0 y 59)
		this.hora = hora;
		if(lugar.length() < 10 && lugar.length() > 50 ) throw new  InputMismatchException("Entrada no valida, lugar: mínimo 10 caracteres, máximo 50 caracteres");  
		this.lugar = lugar;
		if(origen.length() > 100) throw new InputMismatchException("Entrada no valida, origen: máximo 100 caracteres");
		this.origen = origen;
		if(consecuencias.length() > 100) throw new InputMismatchException("Entrada no valida, consecuencias: máximo 100 caracteres");
		this.consecuencias = consecuencias;
	};

}
