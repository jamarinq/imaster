package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.Lider;
import model.vo.Proyecto;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

public class ProyectoDao {

    public ArrayList<Proyecto> query_requerimiento_1() throws SQLException {

        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
        String query = "SELECT Fecha_Inicio,Numero_Habitaciones, Clasificacion FROM Proyecto p WHERE Ciudad = ?";
        PreparedStatement pStatement = conn.prepareStatement(query);
        pStatement.setString(1, "Manizales");
        // Ejecutar el query y almacenar la respuesta
        ResultSet respuesta = pStatement.executeQuery();
        while(respuesta.next()) {
        	Proyecto proyecto = new Proyecto();
        	proyecto.setFecha_inicio(respuesta.getString("Fecha_Inicio"));
        	proyecto.setNum_habitaciones(respuesta.getInt("Numero_Habitaciones"));
        	proyecto.setClasificacion(respuesta.getString("Clasificacion"));
        	//System.out.println(respuesta.getString("Clasificacion"));
        	proyectos.add(proyecto);
        }
        
        
        conn.close();
        pStatement.close();
        return proyectos;

    }

    
    public ArrayList<Proyecto> query_requerimiento_2() throws SQLException {
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
        String query = "SELECT p.Fecha_Inicio, p.Numero_Habitaciones, p.Clasificacion, l.Nombre, l.Primer_Apellido, t.Estrato FROM Proyecto p INNER JOIN Lider l USING (ID_Lider) INNER JOIN Tipo t USING (ID_Tipo) WHERE p.Ciudad = ?";
        PreparedStatement pStatement = conn.prepareStatement(query);
        pStatement.setString(1, "Manizales");
        // Ejecutar el query y almacenar la respuesta
        ResultSet respuesta = pStatement.executeQuery();
        while(respuesta.next()) {
        	Proyecto proyecto = new Proyecto();
        	
        	proyecto.setFecha_inicio(respuesta.getString("Fecha_Inicio"));
        	proyecto.setNum_habitaciones(respuesta.getInt("Numero_Habitaciones"));
        	proyecto.setClasificacion(respuesta.getString("Clasificacion"));
        	Lider lider = new Lider(respuesta.getString("Nombre"),respuesta.getString("Primer_Apellido"));
        	proyecto.setLider(lider);
        	proyecto.setEstrato_proyecto(respuesta.getInt("Estrato"));
        	//System.out.println(respuesta.getString("Clasificacion"));
        	proyectos.add(proyecto);
        }
        
        
        conn.close();
        pStatement.close();
        return proyectos;
        
    }// Fin del método query_requerimiento_2

    
    public ArrayList<Proyecto> query_requerimiento_3() throws SQLException {
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
        String query = "SELECT COUNT(p.clasificacion) AS Condominios, Constructora FROM Proyecto p WHERE p.Clasificacion = ? GROUP BY Constructora";
        PreparedStatement pStatement = conn.prepareStatement(query);
        pStatement.setString(1, "Condominio");
        // Ejecutar el query y almacenar la respuesta
        ResultSet respuesta = pStatement.executeQuery();
        while(respuesta.next()) {
        	Proyecto proyecto = new Proyecto();
        	proyecto.setNum_condominios(respuesta.getInt("Condominios"));
        	proyecto.setNombre_constructora(respuesta.getString("Constructora"));
        	//System.out.println(respuesta.getString("Clasificacion"));
        	proyectos.add(proyecto);
        }
        
        
        conn.close();
        pStatement.close();
        return proyectos;
    }// Fin del método query_requerimiento_3

    
    public ArrayList<Proyecto> query_requerimiento_5() throws SQLException{
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
        String query = "SELECT COUNT(p.clasificacion) AS Condominios, Constructora FROM Proyecto p WHERE p.Clasificacion = ? GROUP BY Constructora HAVING Condominios > 11 ORDER BY Condominios ASC";
        PreparedStatement pStament = conn.prepareStatement(query);
        pStament.setString(1, "Condominio");
        ResultSet respuesta =  pStament.executeQuery();
        
        while(respuesta.next()) {
        	Proyecto proyecto = new Proyecto();
        	proyecto.setNum_condominios(respuesta.getInt("Condominios"));
        	proyecto.setNombre_constructora(respuesta.getString("Constructora"));
        	proyectos.add(proyecto);
        }        
        
        return proyectos;
    }// Fin del método query_requerimiento_4

}