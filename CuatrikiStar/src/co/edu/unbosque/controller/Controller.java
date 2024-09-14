package co.edu.unbosque.controller;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {

	private VentanaPrincipal ventanaprincipal;
	private Juego  juego;
	private Jugador jugador1;
	private Jugador jugador2;

	public Controller() {
		ventanaprincipal = new VentanaPrincipal();
		asignarOyentes();	
	}

	public void asignarOyentes() {

		ventanaprincipal.getpInicio().getStartButton().addActionListener(e -> abrirPantallaRegistro());
		ventanaprincipal.getpInicio().getGameHistoryButton().addActionListener(e -> abrirPantallaHistorialPartidas());
		ventanaprincipal.getrJugador().getPlayButton().addActionListener(e -> irAJugar());
		ventanaprincipal.getrJugador().getGuardarJugador1().addActionListener(e -> guardarJugador());
		ventanaprincipal.getrJugador().getGuardarJugador2().addActionListener(e -> guardarJugador());
		ventanaprincipal.getrJugador().getPlayButton().addActionListener(e -> irAJugar());
		ventanaprincipal.getjCuatriki().getBackMenuButton().addActionListener(e -> BackToMenu());
		ventanaprincipal.getjCuatriki().getGameHButton().addActionListener(e -> abrirPantallaHistorialPartidas());
		ventanaprincipal.getjCuatriki().getRestartButton().addActionListener(e -> ReiniciarTablero());
		ventanaprincipal.gethPartidas().getBackMenuButton().addActionListener(e -> BackToMenu());
		ventanaprincipal.gethPartidas().getBackToGame().addActionListener(e -> BackToGame());
		
		
	}
	
	private void guardarJugador() {
		String nombre1 = ventanaprincipal.getrJugador().getNombreJugador1().getText();
		String nombre2 =  ventanaprincipal.getrJugador().getNombreJugador2().getText();
		
		jugador1 = new Jugador(nombre1, 'x');
		System.out.println(jugador1);
		
		jugador2 = new Jugador(nombre2, 'o');
		System.out.println(jugador2);
		boolean turnoJugador = true;

	}

	private void abrirPantallaRegistro() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getrJugador());
	}

	private void abrirPantallaHistorialPartidas() {

		ventanaprincipal.mostrarPanel(ventanaprincipal.gethPartidas());

	}

	private void irAJugar() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getjCuatriki());
	}

	private void BackToMenu() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getpInicio());

	}
	
	private void BackToGame() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getjCuatriki());
		
	}

	private void ReiniciarTablero() {

		//Añadir funcion

		JOptionPane.showInternalMessageDialog(null, null, ("Falta añadir funcionalidad"), 0, null);

	}
}
