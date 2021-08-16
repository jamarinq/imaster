package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Lider;

public class LiderDao {

    public ArrayList<Lider> query_requerimiento_4() throws SQLException {
        ArrayList<Lider> lideres = new ArrayList<Lider>();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
        String query = "SELECT Nombre, Primer_Apellido FROM Lider l INNER JOIN Proyecto p USING (ID_Lider) WHERE Ciudad = ?";
        PreparedStatement pStament = conn.prepareStatement(query);
        pStament.setString(1, "Manizales");
        ResultSet respuesta = pStament.executeQuery();
        
        while(respuesta.next()) {
        	Lider lider = new Lider(respuesta.getString("Nombre"),respuesta.getString("Primer_Apellido"));
        	lideres.add(lider);
        }
        conn.close();
        pStament.close();
        
        return lideres;
    }// Fin del método query_requerimiento_4

}