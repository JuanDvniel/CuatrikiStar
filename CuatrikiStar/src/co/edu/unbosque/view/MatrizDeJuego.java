package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MatrizDeJuego extends JPanel {

    private JButton[][] botones = new JButton[4][4]; 

    public MatrizDeJuego() {
    	 setBounds(0, 0, 596, 551); 
         setOpaque(false);
         setLayout(new GridLayout(4, 4, 2, 2));
    
        
      
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                JButton boton = new JButton();
                boton.setBounds(0, 0, 149, 138); 
                boton.setContentAreaFilled(false);
                boton.setBorderPainted(false);
                boton.setFocusPainted(false);
                botones[r][c] = boton; 
                add(boton); 
            }
        }

        setVisible(true);
    }
    private void dibujarFondo() {
    	
	}

    public JButton[][] getBotones() {
        return botones;
    }
}
