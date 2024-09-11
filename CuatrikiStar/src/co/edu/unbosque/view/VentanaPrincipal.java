package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private PantallaInicio pInicio;

	public VentanaPrincipal() {

		setTitle("CiatrikiStar");
		setSize(1300, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		 pInicio = new PantallaInicio();
	        pInicio.setBounds(0, 0, 1300, 900);
	        getContentPane().add(pInicio);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}


