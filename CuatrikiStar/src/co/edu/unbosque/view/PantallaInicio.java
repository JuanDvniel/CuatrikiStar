package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.ImageConfig;

public class PantallaInicio extends JPanel {

	private JButton startButton;
	private JButton gameHistoryButton;
	private ImageConfig Fondo;

	public PantallaInicio() {

		setBounds(0, 0, 975, 675);
		setBackground(null);
		setLayout(null);
		setVisible(true);

		inicializarComponentes();

	}

	public void inicializarComponentes() {

		// Botón para iniciar el juego
        startButton = new JButton();
        startButton.setBounds(387, 450, 207, 96);
        startButton.setContentAreaFilled(false);  // Mantener invisible pero funcional
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        add(startButton);

        // Botón para ver el historial de partidas
        gameHistoryButton = new JButton();
        gameHistoryButton.setBounds(341, 525, 298, 77);
        gameHistoryButton.setContentAreaFilled(false);  // Mantener invisible pero funcional
        gameHistoryButton.setBorderPainted(false);
        gameHistoryButton.setFocusPainted(false);
        add(gameHistoryButton);
		
		ImageIcon GameH = new ImageIcon(getClass().getResource("/images/JugarCuatriki/GAME HISTORY.png"));
		JLabel labelGameH = new JLabel(GameH);
		labelGameH.setBounds(341, 525, 298, 77);
		add(labelGameH);

		ImageIcon StartButton = new ImageIcon(getClass().getResource("/images/PanelInicio/STARTBUTTON.png"));
		JLabel labelStartButton = new JLabel(StartButton);
		labelStartButton.setBounds(387, 450, 207, 96);
		add(labelStartButton);

		ImageIcon Logo = new ImageIcon(getClass().getResource("/images/PanelInicio/LOGO.png"));
		JLabel labelLogo = new JLabel(Logo);
		labelLogo.setBounds(0,0,975,675);
		add(labelLogo);

		Fondo = new ImageConfig();
		Fondo.dibujarFondo(this);

	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public JButton getGameHistoryButton() {
		return gameHistoryButton;
	}

	public void setGameHistoryButton(JButton gameHistoryButton) {
		this.gameHistoryButton = gameHistoryButton;
	}

}
