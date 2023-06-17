package procesos;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Administrativo extends Usuario {
	private String area;
	private String experienciaPrevia;
 
	public Administrativo() {};

	public Administrativo(String nombre, LocalDate fechaNacimiento, int run, String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, run);
		if(area.length() < 5 && area.length() > 20) throw new  InputMismatchException("Entrada no valida, área: mínimo 5 caracteres, máximo 20 caracteres");  
		this.area = area;

		if(experienciaPrevia.length()  > 100) throw new  InputMismatchException("Entrada no valida, experiencia previa:  máximo 100 caracteres");  
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String analizarUsuario() {
		return super.analizarUsuario() + " " + area + " " + experienciaPrevia;
	}
}
