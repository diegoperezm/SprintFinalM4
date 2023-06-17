package procesos;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente extends Usuario {

	private String apellidos;
	private int telefono;
	private String afp;
	private int sistemaSalud;
	private String direccion;
	private String comuna;
	private int edad;

	public Cliente() {
	};

	public Cliente(String nombre, LocalDate fechaNacimiento, int run, String apellidos,
			int telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
		super(nombre, fechaNacimiento, run);

		if (apellidos.length() < 5 || apellidos.length() > 30)
			throw new InputMismatchException("Entrada no valida, apellidos: mínimo 5 caracteres, máximo 30 ");
		this.apellidos = apellidos;
		if (!validarFono(telefono))
			throw new InputMismatchException("Entrada no valida, Telefono: debe ingresar numeros");
		this.telefono = telefono;
		if (afp.length() < 4 || afp.length() > 30)
			throw new InputMismatchException("Entrada no valida, afp: mínimo 4 caracteres, máximo 30");
		this.afp = afp;
		if (sistemaSalud < 1 || sistemaSalud > 2)
			throw new InputMismatchException("Entrada no valida, sistema salud: solo puede ser 1(Fonasa) o 2(Isapre)");
		this.sistemaSalud = sistemaSalud;
		if (direccion.length() > 70)
			throw new InputMismatchException("Entrada no valida, dirección: máximo 70 caracteres");
		this.direccion = direccion;

		if (comuna.length() > 50)
			throw new InputMismatchException("Entrada no valida, comuna: máximo 50 caracteres");
		this.comuna = comuna;
		if (edad < 0 || edad > 149)
			throw new InputMismatchException("Entrada no valida, edad: número mayor o igual a cero, y menor a 150");
		this.edad = edad;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public int getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(int sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String obtenerNombre() {
		return getNombre() + " " + getApellidos();
	}

	@Override
	public String analizarUsuario() {
		return super.analizarUsuario() + " " + this.toString();
	}
	
	@Override
	public String toString() {
		return "Cliente [apellidos=" + apellidos + ", telefono=" + telefono + ", afp=" + afp + ", sistemaSalud="
				+ sistemaSalud + ", direccion=" + direccion + ", comuna=" + comuna + ", edad=" + edad + "]";
	}

	public boolean validarFono(int telefono) {
		Pattern formatoFono = Pattern.compile("[0-9]*");
		Matcher matchFono = formatoFono.matcher(Integer.toString(telefono));
		return matchFono.find();
	}

}