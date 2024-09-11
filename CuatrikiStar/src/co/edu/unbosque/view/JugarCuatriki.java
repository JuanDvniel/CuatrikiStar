package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JugarCuatriki extends JPanel{

	public JugarCuatriki() {

		setBounds(0, 0, 1300, 900);
		setBackground(null);
		setLayout(null);
		setVisible(true);

		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
	
		ImageIcon Demo1Screen = new ImageIcon(getClass().getResource("/images/JugarCuatriki/Demo1Screen.png"));
		JLabel labelDemo1Screen = new JLabel(Demo1Screen);
		labelDemo1Screen.setBounds(0,0,1300,900);
		add(labelDemo1Screen);
		
	}
	
}
