package procesos;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
//    ArrayList<Asesoria> listaAsesorias;
    ArrayList<Usuario> listaAsesorias;
    ArrayList<Capacitacion> listaCapacitaciones; 

    public Contenedor() {
//		this.listaAsesorias = new ArrayList<Asesoria>();
		this.listaAsesorias = new ArrayList<Usuario>();
		this.listaCapacitaciones =  new ArrayList<Capacitacion>();
	}

//   	public ArrayList<Asesoria> getListaAsesorias() {
//		return listaAsesorias;
//	}


	public ArrayList<Usuario> getListaAsesorias() {
		return listaAsesorias;
	}

//		public void setListaAsesorias(ArrayList<Asesoria> listaAsesorias) {
//		this.listaAsesorias = listaAsesorias;
//	}


	
	public void setListaAsesorias(ArrayList<Usuario> listaAsesorias) {
		this.listaAsesorias = listaAsesorias;
	}

	public ArrayList<Capacitacion> getListaCapacitaciones() {
		return listaCapacitaciones;
	}

	public void setListaCapacitaciones(ArrayList<Capacitacion> listaCapacitaciones) {
		this.listaCapacitaciones = listaCapacitaciones;
	}

//	public void almacenarCliente(Asesoria cliente) {
 //      listaAsesorias.add(cliente);
 //   }
	public void almacenarCliente(Usuario cliente) {
       listaAsesorias.add(cliente);
    }

//		public void almacenarProfesional(Asesoria profesional) {
//       listaAsesorias.add(profesional);	
//    }


	public void almacenarProfesional(Usuario profesional) {
       listaAsesorias.add(profesional);	
    }

//		public void almacenarAdministrativo(Asesoria administrativo) {
//       listaAsesorias.add(administrativo);	
 //   }


	
	public void almacenarAdministrativo(Usuario administrativo) {
       listaAsesorias.add(administrativo);	
    }

	public void almacenarCapacitacion(Capacitacion capacitacion) {
       listaCapacitaciones.add(capacitacion);	
    }

    public void eliminarUsuario(int run) {
//     System.out.println( listaAsesorias.contains(run));

    for (Usuario usuario : listaAsesorias) {
    	 if(usuario.getRun() == run)
    	  listaAsesorias.remove(listaAsesorias.indexOf(usuario));
     }
      System.out.println(this.getListaAsesorias());
    }	
    
    public void listarUsuarios() {
    	/*
    	permite desplegar la lista completa de usuarios, independiente
    	del tipo. 
    	???
    	En este método solo se deben desplegar los datos de
        la clase usuario.  ????
    	*/
       for (Asesoria asesoria : listaAsesorias) {
	        System.out.println(asesoria.analizarUsuario());	
	   }
    }
/*
 * recibe un tipo de usuario (cliente, administrador o profesional), y 
 * retorna los datos respectivos según el tipo de usuario.
 */
    public void listarUsuariosPorTipo(Asesoria tipoUsuario) {
//       List<Asesoria> listaPorTipoUsuario = new ArrayList<>();
//       List<Asesoria> listaUsuarios = this.getListaAsesorias(); 

       List<Usuario> listaPorTipoUsuario = new ArrayList<>();
       List<Usuario> listaUsuarios = this.getListaAsesorias(); 


       
     // verficar este codigo 
       if(listaUsuarios.size() < 1) {
    	   System.out.println("NO EXISTEN USUARIOS REGISTRADOS");
       };
       
//       for (Asesoria usuario : listaUsuarios) {
//    	   if(usuario.getClass().equals(tipoUsuario.getClass())) {
//    		   listaPorTipoUsuario.add(usuario);
//    	   }
//       }

       for (Usuario usuario : listaUsuarios) {
    	   if(usuario.getClass().equals(tipoUsuario.getClass())) {
    		   listaPorTipoUsuario.add(usuario);
    	   }
       }
 
//      for (Asesoria usuario : listaPorTipoUsuario) {
//	        System.out.println(usuario);	
//	  } 

      for (Usuario usuario : listaPorTipoUsuario) {
	        System.out.println(usuario);	
	  } 


      
	}
    	
/*	
 *Listar capacitaciones: 
 *este método despliega las capacitaciones registradas en la
 * lista respectiva, 
 * ????
 * junto con los datos del cliente al que está asociada dicha
 *  capacitación. 
 *  ???
 */
	
    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : listaCapacitaciones) {
		  System.out.println(capacitacion);	
		} 
    }	
}
