package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.Controlador;
import model.vo.Lider;
import model.vo.Proyecto;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Vista_GUI {

	private JFrame frmRetojoseMarin;

	public JFrame getFrame() {
		return frmRetojoseMarin;
	}

	public void setFrame(JFrame frame) {
		this.frmRetojoseMarin = frame;
	}

	/**
	 * Create the application.
	 */
	public Vista_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRetojoseMarin = new JFrame();
		frmRetojoseMarin.setResizable(false);
		frmRetojoseMarin.setTitle("Reto5_JOSE MARIN");
		frmRetojoseMarin.setLocation(0, 0);
		frmRetojoseMarin.setBounds(100, 100, 801, 177);
		frmRetojoseMarin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRetojoseMarin.getContentPane().setLayout(new GridLayout(0, 5, 1, 0));
		
	/*
	 * Añadimos los botones con los manejadores de eventos	
	 */
		JButton botonRequerimiento1 = new JButton("Requerimiento_1");
		botonRequerimiento1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRequerimiento1 frame = new VentanaRequerimiento1();
				frame.setVisible(true);
			}
		});
		frmRetojoseMarin.getContentPane().add(botonRequerimiento1);
		
		JButton botonRequerimiento2 = new JButton("Requerimiento_2");
		botonRequerimiento2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRequerimiento2 frame = new VentanaRequerimiento2();
				frame.setVisible(true);
			}
		});
		frmRetojoseMarin.getContentPane().add(botonRequerimiento2);
		
		JButton botonRequerimiento3 = new JButton("Requerimiento_3");
		botonRequerimiento3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRequerimiento3 frame = new VentanaRequerimiento3();
				frame.setVisible(true);
			}
		});
		frmRetojoseMarin.getContentPane().add(botonRequerimiento3);
		
		JButton botonRequerimiento4 = new JButton("Requerimiento_4");
		botonRequerimiento4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRequerimiento4 frame = new VentanaRequerimiento4();
				frame.setVisible(true);
			}
		});
		frmRetojoseMarin.getContentPane().add(botonRequerimiento4);
		
		JButton botonRequerimiento5 = new JButton("Requerimiento_5");
		botonRequerimiento5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRequerimiento5 frame = new VentanaRequerimiento5();
				frame.setVisible(true);
			}
		});
		frmRetojoseMarin.getContentPane().add(botonRequerimiento5);
	}
		
}
