package view;


import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controlador;
import model.vo.Lider;
import model.vo.Proyecto;

public class Vista {

    public static final Controlador controlador = new Controlador();

    public static void vista_requerimiento_1() {

        try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_1();
            for (int i = 0; i < proyectos.size(); i++) {
            	String salida= "Fecha_Inicio: " + proyectos.get(i).getFecha_inicio() + " - Numero_Habitaciones: " + proyectos.get(i).getNum_habitaciones() + " - Clasificación: " +proyectos.get(i).getClasificacion();
            	System.out.println(salida);
            
            }
            

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void vista_requerimiento_2() {
        try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_2();
            for (int i = 0; i < proyectos.size(); i++) {
            	String salida= "Fecha_Inicio: " + proyectos.get(i).getFecha_inicio() + " - Numero_Habitaciones: " + proyectos.get(i).getNum_habitaciones() + " - Clasificación: " + proyectos.get(i).getClasificacion() + " - Nombre_Lider: " + proyectos.get(i).getLider().getNombre() + " - Apellido_Lider: " + proyectos.get(i).getLider().getApellido() + " - Estrato_proyecto: " + proyectos.get(i).getEstrato_proyecto();
            	System.out.println(salida);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void vista_requerimiento_3() {
    	try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_3();
            for (int i = 0; i < proyectos.size(); i++) {
            	Proyecto proyecto = proyectos.get(i);
            	String salida= "Condominios: " + proyecto.getNum_condominios() + " - Constructora: " + proyecto.getNombre_constructora();
            	System.out.println(salida);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void vista_requerimiento_4() {
    	try {
			ArrayList<Lider> lideres = controlador.Solucionar_requerimiento_4();
			for (int i = 0 ; i < lideres.size() ; i++) {
				Lider lider = lideres.get(i);
				String salida = "Nombre_Lider: " + lider.getNombre() + " - Apellido_Lider: " + lider.getApellido(); 
				System.out.println(salida);
			}
		} catch (SQLException e) {
			System.err.println("Ha ocurrido un error!" + e.getMessage());
		}
        
    }

    public static void vista_requerimiento_5() {
        try {
        	ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_5();
        	for(int i=0; i < proyectos.size(); i++) {
        		Proyecto proyecto = proyectos.get(i);
        		String salida = "Condominios: " + proyecto.getNum_condominios() + " - Constructora: " + proyecto.getNombre_constructora();
        		System.out.println(salida);
        	}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }

}
