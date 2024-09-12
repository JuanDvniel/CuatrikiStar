package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import config.FontConfig;

public class HistorialPartidas extends JPanel {

	private JButton backMenuButton;
	private JButton backToGame;
	private JTextArea ConsolaHistorial;
	private FontConfig fontConfig;  // Instancia de Configuracion de Fuente.

	public HistorialPartidas() {
		setBounds(0, 0, 1300, 900);
		setBackground(null);
		setLayout(null);
		setVisible(true);


		fontConfig = new FontConfig(); 

		inicializarComponentes();

	}

	private void inicializarComponentes() {

		// Botón para volver al menú principal
		backMenuButton = new JButton();
		backMenuButton.setBounds(731, 795, 397, 102);
		backMenuButton.setContentAreaFilled(false);
		backMenuButton.setBorderPainted(false);
		backMenuButton.setFocusPainted(false);
		add(backMenuButton);

		// Botón para volver a la partida
		backToGame = new JButton();
		backToGame.setBounds(137, 795, 435, 102);
		backToGame.setContentAreaFilled(false);
		backToGame.setBorderPainted(false);
		backToGame.setFocusPainted(false);
		add(backToGame);

		// Donde se mostrará la consola
		ConsolaHistorial = new JTextArea();
		ConsolaHistorial.setBounds(70, 336, 1166, 409);
		ConsolaHistorial.setEditable(true);
		ConsolaHistorial.setOpaque(false);
		ConsolaHistorial.setBorder(new EmptyBorder(0, 0, 0, 0));
		ConsolaHistorial.setFont(fontConfig.getFuentePersonalizada());
		ConsolaHistorial.setForeground(new Color(64, 205, 80));
		add(ConsolaHistorial);

		JLabel labelBackGame = new JLabel(new ImageIcon(getClass().getResource("/images/HistorialPartidas/BACK TO GAME.png")));
		labelBackGame.setBounds(137, 795, 435, 102);
		add(labelBackGame);

		JLabel labelBackMenu = new JLabel(new ImageIcon(getClass().getResource("/images/JugarCuatriki/BACK TO MENU.png")));
		labelBackMenu.setBounds(731, 795, 409, 102);
		add(labelBackMenu);

		ImageIcon FondoHistorial = new ImageIcon(getClass().getResource("/images/HistorialPartidas/HistorialBack.png"));
		JLabel labelFondoHistorial = new JLabel(FondoHistorial);
		labelFondoHistorial.setBounds(0, 0, 1300, 900);
		add(labelFondoHistorial);

	}

	public JButton getBackMenuButton() {
		return backMenuButton;
	}

	public void setBackMenuButton(JButton backMenuButton) {
		this.backMenuButton = backMenuButton;
	}

	public JButton getBackToGame() {
		return backToGame;
	}

	public void setBackToGame(JButton backToGame) {
		this.backToGame = backToGame;
	}

	public JTextArea getConsolaHistorial() {
		return ConsolaHistorial;
	}

	public void setConsolaHistorial(JTextArea consolaHistorial) {
		ConsolaHistorial = consolaHistorial;
	}

	public FontConfig getFontConfig() {
		return fontConfig;
	}

	public void setFontConfig(FontConfig fontConfig) {
		this.fontConfig = fontConfig;
	}


}