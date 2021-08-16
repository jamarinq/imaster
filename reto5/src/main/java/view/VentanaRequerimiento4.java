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
import model.vo.Lider;

public class VentanaRequerimiento4 extends JFrame {

	private JPanel contentPane;
    public static final Controlador controlador = new Controlador();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRequerimiento4() {
		setTitle("Requerimiento_4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 677);
		setLocation(0, 0);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		vista_requerimiento_4();
	}
	
    public void vista_requerimiento_4() {
    	
    	
    	try {
			ArrayList<Lider> lideres = controlador.Solucionar_requerimiento_4();
			contentPane.setLayout(new GridLayout(lideres.size(),2,10,10));
			
			for (int i = 0 ; i < lideres.size() ; i++) {
				Lider lider = lideres.get(i);
        		JLabel lblNewLabel1 = new JLabel();
        		contentPane.add(lblNewLabel1);
        		lblNewLabel1.setText("Nombre_Lider: " + lider.getNombre());
        		
        		JLabel lblNewLabel2 = new JLabel();
        		contentPane.add(lblNewLabel2);
        		lblNewLabel2.setText("Apellido_Lider: " + lider.getApellido());  
			}
		} catch (SQLException e) {
			System.err.println("Ha ocurrido un error!" + e.getMessage());
		}
        
    }

}
