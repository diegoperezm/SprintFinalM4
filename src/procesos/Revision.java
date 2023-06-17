package procesos;

import java.util.InputMismatchException;

public class Revision {
	private int idRevision;
	private int idVisita;
	private String nombreRevision;
	private String detalle;
	private int estado;
	private static int idAuto = 0;

	public Revision(int idVisita, String nombreRevision, String detalle, int estado) {
		this.idRevision = ++idAuto;
		this.idVisita = idVisita;

		if (nombreRevision.length() < 10 || nombreRevision.length() > 50)
			throw new InputMismatchException("Entrada no valida, nombre revisión:  mínimo 10 caracteres, máximo 50 ");
		this.nombreRevision = nombreRevision;

		if (detalle.length() > 100)
			throw new IllegalArgumentException("Entrada invalida, detalle: máximo 100 caracteres");
		this.detalle = detalle;
		if (estado < 1 || estado > 3)
			throw new IllegalArgumentException(
					"Entrada invalida, estado:1 (sin problemas), 2 (con observaciones), 3 (no aprueba), solo se\n"
							+ "pueden ingresar los valores antes indicados.  ");
		this.estado = estado;
	}

	public int getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Revision [idRevision=" + idRevision + ", idVisita=" + idVisita + ", nombreRevision=" + nombreRevision
				+ ", detalle=" + detalle + ", estado=" + estado + "]";
	}

	
}
