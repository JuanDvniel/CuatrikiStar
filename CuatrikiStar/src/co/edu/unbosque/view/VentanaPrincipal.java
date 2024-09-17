package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame{

	private PantallaInicio pInicio;
	private RegistroJugador rJugador;
	private JugarCuatriki jCuatriki;
	private HistorialPartidas hPartidas;

	public VentanaPrincipal() {

		setTitle("CuatrikiStar");
		setSize(975, 697);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);


		pInicio = new PantallaInicio();
		pInicio.setBounds(0, 0, 975, 675);
		getContentPane().add(pInicio);

		rJugador = new RegistroJugador();
		rJugador.setBounds(0, 0, 975, 675);
		rJugador.setVisible(false);
		getContentPane().add(rJugador);

		jCuatriki = new JugarCuatriki();
		jCuatriki.setBounds(0, 0, 975, 675);
		jCuatriki.setVisible(false);
		getContentPane().add(jCuatriki);

		hPartidas = new HistorialPartidas();
		hPartidas.setBounds(0, 0, 975, 675);
		hPartidas.setVisible(false);
		getContentPane().add(hPartidas);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void mostrarPanel(JPanel panel) {

		getContentPane().removeAll();
		getContentPane().add(panel);
		panel.setVisible(true);
		revalidate();
		repaint();

	}

	public PantallaInicio getpInicio() {
		return pInicio;
	}

	public RegistroJugador getrJugador() {
		return rJugador;
	}

	public JugarCuatriki getjCuatriki() {
		return jCuatriki;
	}

	public HistorialPartidas gethPartidas() {
		return hPartidas;

	}

}



