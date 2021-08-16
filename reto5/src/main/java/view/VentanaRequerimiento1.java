package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.vo.Proyecto;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class VentanaRequerimiento1 extends JFrame {

	private JPanel contentPane;
    public static final Controlador controlador = new Controlador();
	
	/**
	 * Create the frame.
	 */
	public VentanaRequerimiento1() {
		setResizable(false);
		setTitle("Requerimiento_1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(0, 0);
		setBounds(100, 100, 874, 653);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		vista_requerimiento_1();
	}
	
    public void vista_requerimiento_1() {

        try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_1();

    		contentPane.setLayout(new GridLayout(proyectos.size(),3,10,10));
    		
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
            
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
