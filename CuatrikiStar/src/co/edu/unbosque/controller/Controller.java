package co.edu.unbosque.controller;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {

private VentanaPrincipal ventanaprincipal;
	
	public Controller() {
		ventanaprincipal = new VentanaPrincipal();
		asignarOyentes();	
	}
	
	public void asignarOyentes() {
		
		ventanaprincipal.getpInicio().getStartButton().addActionListener(e -> abrirPantallaRegistro());
		ventanaprincipal.getpInicio().getGameHistoryButton().addActionListener(e -> abrirPantallaHistorialPartidas());
		ventanaprincipal.getrJugador().getPlayButton().addActionListener(e -> irAJugar());
		ventanaprincipal.getjCuatriki().getBackMenuButton().addActionListener(e -> BackToMenu());
		ventanaprincipal.getjCuatriki().getGameHButton().addActionListener(e -> abrirPantallaHistorialPartidas());
	}
	
	private void abrirPantallaRegistro() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getrJugador());
	}
	
	private void abrirPantallaHistorialPartidas() {
		
		//Añadir Pantalla
		
		JOptionPane.showInternalMessageDialog(null, null, ("Pantalla no existe aun"), 0, null);
	}
	
	private void irAJugar() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getjCuatriki());
	}
	
	private void BackToMenu() {
		ventanaprincipal.mostrarPanel(ventanaprincipal.getpInicio());

	}
}
