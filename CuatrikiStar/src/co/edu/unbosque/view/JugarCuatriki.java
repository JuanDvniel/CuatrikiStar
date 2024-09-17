package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import config.FontConfig;

public class JugarCuatriki extends JPanel {

    private JButton gameHButton;
    private JButton backMenuButton;
    private JButton restartButton;
    private JTextArea consola;
    private FontConfig fontConfig;
    private MatrizDeJuego matrizDeJuego;

    public JugarCuatriki() {
        setBounds(0, 0, 975, 675);
        setLayout(null);
        setVisible(true);
        fontConfig = new FontConfig();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Donde se mostrará la consola
        consola = new JTextArea();
        consola.setBounds(628, 202, 298, 377);
        consola.setEditable(true);
        consola.setOpaque(false);
        consola.setBorder(new EmptyBorder(0, 0, 0, 0));
        consola.setFont(fontConfig.getFuentePersonalizada());
        consola.setForeground(new Color(64, 205, 80));
        add(consola);

        // Botón para reiniciar el juego
        restartButton = new JButton();
        restartButton.setBounds(56, 588, 208, 77);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(false);
        restartButton.setFocusPainted(false);
        add(restartButton);

        // Botón para volver al menú principal
        backMenuButton = new JButton();
        backMenuButton.setBounds(293, 588, 307, 77);
        backMenuButton.setContentAreaFilled(false);
        backMenuButton.setBorderPainted(false);
        backMenuButton.setFocusPainted(false);
        add(backMenuButton);

        // Botón para ver el historial de partidas
        gameHButton = new JButton();
        gameHButton.setBounds(628, 588, 298, 77);
        gameHButton.setContentAreaFilled(false);
        gameHButton.setBorderPainted(false);
        gameHButton.setFocusPainted(false);
        add(gameHButton);
        
        matrizDeJuego = new MatrizDeJuego();
        matrizDeJuego.setBounds(80, 159, 447, 413);  // Posicionar la matriz de juego
        add(matrizDeJuego);  // Agregar la matriz al panel
        
        ImageIcon fondoMatriz = new ImageIcon(getClass().getResource("/images/matriz/MATRIZDIBUJO.png"));
		JLabel labelfondoMatriz = new JLabel(fondoMatriz);
		labelfondoMatriz.setBounds(80, 159, 447, 413);
		add(labelfondoMatriz);

        // Imágenes para los botones
        JLabel labelRestart = new JLabel(new ImageIcon(getClass().getResource("/images/JugarCuatriki/RESTART.png")));
        labelRestart.setBounds(56, 588, 208, 77);
        add(labelRestart);

        JLabel labelBackMenu = new JLabel(new ImageIcon(getClass().getResource("/images/JugarCuatriki/BACK TO MENU.png")));
        labelBackMenu.setBounds(293, 588, 307, 77);
        add(labelBackMenu);

        JLabel labelGameH = new JLabel(new ImageIcon(getClass().getResource("/images/JugarCuatriki/GAME HISTORY.png")));
        labelGameH.setBounds(628, 588, 298, 77);
        add(labelGameH);

        // Fondo de pantalla del juego
        JLabel labelDemo1Screen = new JLabel(new ImageIcon(getClass().getResource("/images/JugarCuatriki/Demo1Screen.png")));
        labelDemo1Screen.setBounds(0, 0, 975, 675);
        add(labelDemo1Screen);
    }

	public JButton getGameHButton() {
		return gameHButton;
	}

	public void setGameHButton(JButton gameHButton) {
		this.gameHButton = gameHButton;
	}

	public JButton getBackMenuButton() {
		return backMenuButton;
	}

	public void setBackMenuButton(JButton backMenuButton) {
		this.backMenuButton = backMenuButton;
	}

	public JButton getRestartButton() {
		return restartButton;
	}

	public void setRestartButton(JButton restartButton) {
		this.restartButton = restartButton;
	}

	public JTextArea getConsola() {
		return consola;
	}

	public void setConsola(JTextArea consola) {
		this.consola = consola;
	}

	public FontConfig getFontConfig() {
		return fontConfig;
	}

	public void setFontConfig(FontConfig fontConfig) {
		this.fontConfig = fontConfig;
	}

	public MatrizDeJuego getMatrizDeJuego() {
		return matrizDeJuego;
	}

	public void setMatrizDeJuego(MatrizDeJuego matrizDeJuego) {
		this.matrizDeJuego = matrizDeJuego;
	}
    


}
