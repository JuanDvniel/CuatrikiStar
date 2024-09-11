package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{

	private PantallaInicio pInicio;
	private RegistroJugador rJugador;
	private JugarCuatriki jCuatriki;

	public VentanaPrincipal() {

		setTitle("CuatrikiStar");
		setSize(1300, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		jCuatriki = new JugarCuatriki();
		jCuatriki.setBounds(0, 0, 1300, 900);
		getContentPane().add(jCuatriki);

		pInicio = new PantallaInicio();
		pInicio.setBounds(0, 0, 1300, 900);
		getContentPane().add(pInicio);

		rJugador = new RegistroJugador();
		rJugador.setBounds(0, 0, 1300, 900);
		getContentPane().add(rJugador);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}


