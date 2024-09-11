package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaInicio extends JPanel {

	JButton Start;

	public PantallaInicio() {

		setBounds(0, 0, 1300, 900);
		setBackground(null);
		setLayout(null);
		setVisible(true);

		inicializarComponentes();
	}

	public void inicializarComponentes() {

		Start = new JButton();
		Start.setBounds(516, 625, 276, 128);
		Start.setVisible(false);
		add(Start);

		ImageIcon StartButton = new ImageIcon(getClass().getResource("/images/PanelInicio/STARTBUTTON.png"));
		JLabel labelStartButton = new JLabel(StartButton);
		labelStartButton.setBounds(516, 625, 276, 128);
		add(labelStartButton);

		ImageIcon Logo = new ImageIcon(getClass().getResource("/images/PanelInicio/LOGO.png"));
		JLabel labelLogo = new JLabel(Logo);
		labelLogo.setBounds(0,0,1300,900);
		add(labelLogo);

		ImageIcon Fondo = new ImageIcon(getClass().getResource("/images/PanelInicio/FONDO.png"));
		JLabel labelFondo = new JLabel(Fondo);
		labelFondo.setBounds(0,0,1300,900);
		add(labelFondo);



	}



}
