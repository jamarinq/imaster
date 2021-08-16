package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import model.vo.Proyecto;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;

public class VentanaRequerimiento3 extends JFrame {

	private JPanel contentPane;
    public static final Controlador controlador = new Controlador();

	/**
	 * Create the frame.
	 */
	public VentanaRequerimiento3() {
		setTitle("Requerimiento_3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(0, 0);
		setBounds(100, 100, 603, 167);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		vista_requerimiento_3();
	}
	
	public void vista_requerimiento_3() {

        try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_3();

    		contentPane.setLayout(new GridLayout(proyectos.size(),2,10,10));
    		
            for (int i = 0; i < proyectos.size(); i++) {
            	Proyecto proyecto = proyectos.get(i);
        		JLabel lblNewLabel1 = new JLabel();
        		contentPane.add(lblNewLabel1);
        		lblNewLabel1.setText("Condominios: " + proyecto.getNum_condominios());
        		
        		JLabel lblNewLabel2 = new JLabel();
        		contentPane.add(lblNewLabel2);
        		lblNewLabel2.setText("Constructora: " + proyecto.getNombre_constructora());            
            }
            
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
