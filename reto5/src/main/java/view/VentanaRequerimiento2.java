package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.vo.Proyecto;

public class VentanaRequerimiento2 extends JFrame {

	private JPanel contentPane;
    public static final Controlador controlador = new Controlador();
	
	/**
	 * Create the frame.
	 */
	public VentanaRequerimiento2() {
		setTitle("Requerimiento_2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(0, 0);
		setBounds(100, 100, 1217, 653);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		vista_requerimiento_2();
	}
	
    public void vista_requerimiento_2() {

        try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_2();

    		contentPane.setLayout(new GridLayout(proyectos.size(),6,10,10));
    		
            for (int i = 0; i < proyectos.size(); i++) {
            	Proyecto proyecto = proyectos.get(i);
        		JLabel lblNewLabel1 = new JLabel();
        		contentPane.add(lblNewLabel1);
        		lblNewLabel1.setText("Fecha_Inicio: " + proyecto.getFecha_inicio());
        		
        		JLabel lblNewLabel2 = new JLabel();
        		contentPane.add(lblNewLabel2);
        		lblNewLabel2.setText("Numero_Habitaciones: " + proyecto.getNum_habitaciones());
        		
        		JLabel lblNewLabel3 = new JLabel();
        		contentPane.add(lblNewLabel3);
        		lblNewLabel3.setText("Clasificación: " +proyecto.getClasificacion());
        		
        		JLabel lblNewLabel4 = new JLabel();
        		contentPane.add(lblNewLabel4);
        		lblNewLabel4.setText("Nombre_Lider: " + proyecto.getLider().getNombre());
        		
        		JLabel lblNewLabel5 = new JLabel();
        		contentPane.add(lblNewLabel5);
        		lblNewLabel5.setText("Apellido_Lider: " + proyecto.getLider().getApellido());
        		
        		JLabel lblNewLabel6 = new JLabel();
        		contentPane.add(lblNewLabel6);
        		lblNewLabel6.setText("Estrato_proyecto: " + proyectos.get(i).getEstrato_proyecto());            
            }
                        
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
