package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistroJugador extends JPanel{

	JButton GuardarJugador1;
	JButton GuardarJugador2;
	JButton Play;
	JTextField NombreJugador1;
	JTextField NombreJugador2;

	public RegistroJugador() {

		setBounds(0, 0, 1300, 900);
		setBackground(null);
		setLayout(null);
		setVisible(true);

		inicializarComponentes();
	}

	public void inicializarComponentes() {

		NombreJugador1 = new JTextField();
		NombreJugador1.setBounds(171, 403, 310, 75);
		NombreJugador1.setOpaque(false);
		NombreJugador1.setBorder(new EmptyBorder(0, 0, 0, 0));
		NombreJugador1.setHorizontalAlignment(JTextField.CENTER);

		// Cargar la fuente desde los recursos utilizando getResourceAsStream()
		try {
			InputStream is = getClass().getResourceAsStream("/fonts/Kettler-Bold Regular.otf");
			if (is == null) {
				throw new IOException("No se encontró la fuente en la ruta especificada.");
			}

			Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, is);
			fuentePersonalizada = fuentePersonalizada.deriveFont(Font.PLAIN, 25); // Ajustar estilo y tamaño
			NombreJugador1.setFont(fuentePersonalizada);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			// Aplicar una fuente por defecto si falla la carga de la fuente personalizada
			NombreJugador1.setFont(new Font("Arial", Font.PLAIN, 25));
		}

		// Cambiar el color del texto
		NombreJugador1.setForeground(new Color(0, 161, 211)); // Cambia el color a tu preferencia
		add(NombreJugador1);

		NombreJugador2 = new JTextField();
		NombreJugador2.setBounds(826, 403, 310, 75);
		NombreJugador2.setOpaque(false);
		NombreJugador2.setBorder(new EmptyBorder(0, 0, 0, 0));
		NombreJugador2.setHorizontalAlignment(JTextField.CENTER);

		// Cargar la fuente desde los recursos utilizando getResourceAsStream()
		try {
			InputStream is = getClass().getResourceAsStream("/fonts/Kettler-Bold Regular.otf");
			if (is == null) {
				throw new IOException("No se encontró la fuente en la ruta especificada.");
			}

			Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, is);
			fuentePersonalizada = fuentePersonalizada.deriveFont(Font.PLAIN, 25); // Ajustar estilo y tamaño
			NombreJugador2.setFont(fuentePersonalizada);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			// Aplicar una fuente por defecto si falla la carga de la fuente personalizada
			NombreJugador2.setFont(new Font("Arial", Font.PLAIN, 25));
		}

		// Cambiar el color del texto
		NombreJugador2.setForeground(new Color(0, 161, 211)); // Cambia el color a tu preferencia
		add(NombreJugador2);

		GuardarJugador1 = new JButton();
		GuardarJugador1.setBounds(899, 528, 148, 46);
		GuardarJugador1.setVisible(false);
		add(GuardarJugador1);

		GuardarJugador2 = new JButton();
		GuardarJugador2.setBounds(249, 528, 148, 46);
		GuardarJugador2.setVisible(false);
		add(GuardarJugador2);

		Play = new JButton();
		Play.setBounds(516, 668, 276, 128);
		Play.setVisible(false);
		add(Play);


		ImageIcon GUIPlayers = new ImageIcon(getClass().getResource("/images/RegistroJugador/GU.png"));
		JLabel labelGUIPlayers = new JLabel(GUIPlayers);
		labelGUIPlayers.setBounds(0,0,1300,900);
		add(labelGUIPlayers);

		ImageIcon Players = new ImageIcon(getClass().getResource("/images/RegistroJugador/PLAYERS.png"));
		JLabel labelPlayers = new JLabel(Players);
		labelPlayers.setBounds(0,0,1300,900);
		add(labelPlayers);

		ImageIcon Fondo = new ImageIcon(getClass().getResource("/images/PanelInicio/FONDO.png"));
		JLabel labelFondo = new JLabel(Fondo);
		labelFondo.setBounds(0,0,1300,900);
		add(labelFondo);
	}
}
