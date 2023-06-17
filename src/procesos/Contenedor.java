package procesos;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
	ArrayList<Usuario> listaAsesorias;
	ArrayList<Capacitacion> listaCapacitaciones;

	public Contenedor() {
		this.listaAsesorias = new ArrayList<Usuario>();
		this.listaCapacitaciones = new ArrayList<Capacitacion>();
	}

	public ArrayList<Usuario> getListaAsesorias() {
		return listaAsesorias;
	}

	public void setListaAsesorias(ArrayList<Usuario> listaAsesorias) {
		this.listaAsesorias = listaAsesorias;
	}

	public ArrayList<Capacitacion> getListaCapacitaciones() {
		return listaCapacitaciones;
	}

	public void setListaCapacitaciones(ArrayList<Capacitacion> listaCapacitaciones) {
		this.listaCapacitaciones = listaCapacitaciones;
	}

	public void almacenarCliente(Usuario cliente) {
		listaAsesorias.add(cliente);
	}

	public void almacenarProfesional(Usuario profesional) {
		listaAsesorias.add(profesional);
	}

	public void almacenarAdministrativo(Usuario administrativo) {
		listaAsesorias.add(administrativo);
	}

	public void almacenarCapacitacion(Capacitacion capacitacion) {
		listaCapacitaciones.add(capacitacion);
	}

	public void eliminarUsuario(int run) {

		boolean existe = false;
		if (listaAsesorias.size() < 1) {
			System.out.println("No se han encontrado usuarios registrados.");
			System.out.println(" ");
		}

		for (int i = 0; i < listaAsesorias.size(); i++) {
			if (listaAsesorias.get(i).getRun() == run) {
				listaAsesorias.remove(i);
				existe = true;
			}
		}
		if (!existe) {
			System.out.println("No se ha encontrado al usuario.");
			System.out.println(" ");
		} else {
			System.out.println("Se ha eliminado el usuario.");
			System.out.println(" ");
		}
	}

	public void listarUsuarios() {
		
		if(listaAsesorias.size() < 1) {
			System.out.println("No hay usuarios registrados.");
			System.out.println(" ");
		}
		
		for (Asesoria asesoria : listaAsesorias) {
			System.out.println(asesoria.analizarUsuario());
		}
		System.out.println(" ");
	}

	public void listarUsuariosPorTipo(Asesoria tipoUsuario) {

		List<Usuario> listaPorTipoUsuario = new ArrayList<>();
		List<Usuario> listaUsuarios = this.getListaAsesorias();

		if (listaUsuarios.size() < 1) {
			System.out.println("No existen usuarios registrados");
			System.out.println(" ");
		}

		for (Usuario usuario : listaUsuarios) {
			if (usuario.getClass().equals(tipoUsuario.getClass())) {
				listaPorTipoUsuario.add(usuario);
			}
		}

		for (Usuario usuario : listaPorTipoUsuario) {
			System.out.println(usuario.analizarUsuario() + " " + usuario);
		}

	}

	public void listarCapacitaciones() {
		for (Capacitacion capacitacion : listaCapacitaciones) {
			System.out.println(capacitacion);
		}
	}
}
