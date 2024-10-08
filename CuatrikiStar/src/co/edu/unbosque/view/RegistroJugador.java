package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import config.FontConfig;
import config.ImageConfig;

public class RegistroJugador extends JPanel {


    private JButton guardarJugador1;
    private JButton guardarJugador2;
    private JButton playButton;
    private JTextField nombreJugador1;
    private JTextField nombreJugador2;
    private FontConfig fontConfig;  // Instancia de Configuracion de Fuente.
    private ImageConfig Fondo;

    public RegistroJugador() {
 
        setBounds(0, 0, 975, 675);
        setBackground(null);
        setLayout(null);
        setVisible(true);

        
        fontConfig = new FontConfig(); 

        inicializarComponentes();
    }

    public void inicializarComponentes() {

    	 // Campo de texto para el nombre del Jugador 1
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(113, 306, 232, 56);
        nombreJugador1.setOpaque(false);
        nombreJugador1.setBorder(new EmptyBorder(0, 0, 0, 0));
        nombreJugador1.setHorizontalAlignment(JTextField.CENTER);
        nombreJugador1.setFont(fontConfig.getFuentePersonalizada());
        nombreJugador1.setForeground(new Color(0, 161, 211));
        add(nombreJugador1);

        // Campo de texto para el nombre del Jugador 2
        nombreJugador2 = new JTextField();
        nombreJugador2.setBounds(620, 306, 232, 56);
        nombreJugador2.setOpaque(false);
        nombreJugador2.setBorder(new EmptyBorder(0, 0, 0, 0));
        nombreJugador2.setHorizontalAlignment(JTextField.CENTER);
        nombreJugador2.setFont(fontConfig.getFuentePersonalizada());
        nombreJugador2.setForeground(new Color(0, 161, 211));
        add(nombreJugador2);

        // Botón invisible para guardar el nombre del Jugador 1
        guardarJugador1 = new JButton();
        guardarJugador1.setBounds(180, 400, 148, 46);
        guardarJugador1.setContentAreaFilled(false);  // Mantener invisible pero funcional
        guardarJugador1.setBorderPainted(false);
        guardarJugador1.setFocusPainted(false);
        add(guardarJugador1);

        // Botón invisible para guardar el nombre del Jugador 2
        guardarJugador2 = new JButton();
        guardarJugador2.setBounds(680, 400, 148, 46);
        guardarJugador2.setContentAreaFilled(false);  // Mantener invisible pero funcional
        guardarJugador2.setBorderPainted(false);
        guardarJugador2.setFocusPainted(false);
        add(guardarJugador2);

        // Botón invisible para iniciar el juego
        playButton = new JButton();
        playButton.setBounds(387, 501, 207, 96);
        playButton.setContentAreaFilled(false);  // Mantener invisible pero funcional
        playButton.setBorderPainted(false);
        playButton.setFocusPainted(false);
        add(playButton);

        ImageIcon GUIPlayers = new ImageIcon(getClass().getResource("/images/RegistroJugador/GU.png"));
        JLabel labelGUIPlayers = new JLabel(GUIPlayers);
        labelGUIPlayers.setBounds(0, 0, 975, 675);
        add(labelGUIPlayers);

        ImageIcon Players = new ImageIcon(getClass().getResource("/images/RegistroJugador/PLAYERS.png"));
        JLabel labelPlayers = new JLabel(Players);
        labelPlayers.setBounds(0, 0, 975, 675);
        add(labelPlayers);

        Fondo = new ImageConfig();
		Fondo.dibujarFondo(this);
    }

	public JButton getGuardarJugador1() {
		return guardarJugador1;
	}

	public void setGuardarJugador1(JButton guardarJugador1) {
		this.guardarJugador1 = guardarJugador1;
	}

	public JButton getGuardarJugador2() {
		return guardarJugador2;
	}

	public void setGuardarJugador2(JButton guardarJugador2) {
		this.guardarJugador2 = guardarJugador2;
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public void setPlayButton(JButton playButton) {
		this.playButton = playButton;
	}

	public JTextField getNombreJugador1() {
		return nombreJugador1;
	}

	public void setNombreJugador1(JTextField nombreJugador1) {
		this.nombreJugador1 = nombreJugador1;
	}

	public JTextField getNombreJugador2() {
		return nombreJugador2;
	}

	public void setNombreJugador2(JTextField nombreJugador2) {
		this.nombreJugador2 = nombreJugador2;
	}

	public FontConfig getFontConfig() {
		return fontConfig;
	}

	public void setFontConfig(FontConfig fontConfig) {
		this.fontConfig = fontConfig;
	}
}
