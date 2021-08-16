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

public class VentanaRequerimiento5 extends JFrame {

	private JPanel contentPane;
    public static final Controlador controlador = new Controlador();

	/**
	 * Create the frame.
	 */
	public VentanaRequerimiento5() {
		setTitle("Requerimiento_5");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 141);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		vista_requerimiento_5();
	}
	
    public void vista_requerimiento_5() {
        try {
        	ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_5();
			contentPane.setLayout(new GridLayout(proyectos.size(),2,10,10));
        	for(int i=0; i < proyectos.size(); i++) {
        		Proyecto proyecto = proyectos.get(i);
        		JLabel lblNewLabel1 = new JLabel();
        		contentPane.add(lblNewLabel1);
        		lblNewLabel1.setText("Condominios: " + proyecto.getNum_condominios());
        		
        		JLabel lblNewLabel2 = new JLabel();
        		contentPane.add(lblNewLabel2);
        		lblNewLabel2.setText("Constructora: " + proyecto.getNombre_constructora()); 
        	}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }

}
