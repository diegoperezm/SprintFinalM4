package procesos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capacitacion {
	private int identificador;
	private int rutCliente;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;
	private static int idAuto = 0;

	public Capacitacion() {
	};

	public Capacitacion(int rutCliente, String dia, String hora, String lugar, String duracion,
			int cantidadAsistentes) {	
		this.identificador = ++idAuto;
		if (rutCliente > 99999999) throw new IllegalArgumentException("Entrada invalida, rut: corresponde a un número menor a 99.999.999");
		this.rutCliente = rutCliente;
		if(dia.toLowerCase().equals("lunes") || dia.toLowerCase().equals("martes") || dia.toLowerCase().equals("miercoles") || dia.toLowerCase().equals("jueves") || dia.toLowerCase().equals("viernes") || dia.toLowerCase().equals("sabado") || dia.toLowerCase().equals("domingo") ) {
			this.dia = dia;		
		}else {
			throw new IllegalArgumentException("Entrada invalida. Ingrese un dia entre lunes y domingo");
		}		
		if(!validarHora(hora))
			throw new IllegalArgumentException("Entrada invalida. Ingrese una hora con formato hh:mm (ej: 20:45)");
		this.hora = hora;
		if(lugar.length() < 10 || lugar.length() > 50) throw new IllegalArgumentException("Entrada invalida lugar: mínimo 10 caracteres, máximo 50");
		this.lugar = lugar;
		if(duracion.length() > 70) throw new IllegalArgumentException("Entrada invalida duración: máximo 70 caracteres");
		this.duracion = duracion;
		if(cantidadAsistentes > 1000) throw new IllegalArgumentException("Entrada invalida, cantidad asistentes: máximo 1000 ");
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		if (rutCliente > 99999999) throw new IllegalArgumentException("RUT: corresponde a un número menor a 99.999.999");
		this.rutCliente = rutCliente;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public String mostrarDetalle() {
		String lugar = this.getLugar();
		String hora = this.getHora();
		String dia = this.getDia();
		String duracion = this.getDuracion();
		return String.format("La capacitación será en %s a las %s del día %d, y durará %d minutos", lugar, hora, dia,
				duracion);
	}

	@Override
	public String toString() {
		return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia
				+ ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes="
				+ cantidadAsistentes + "]";
	}
	
	public boolean validarHora(String hora) {
		Pattern formatoHora = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
		Matcher matchHora = formatoHora.matcher(hora);
		return matchHora.find();
	}
	
}
