package co.edu.unbosque.view;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MatrizDeJuego extends JPanel {

    private JButton[][] botones = new JButton[4][4]; 
    private ImageIcon imagenX;
    private ImageIcon imagenO;

    public MatrizDeJuego() {
        setBounds(0, 0, 596, 551); 
        setOpaque(false);
        setLayout(new GridLayout(4, 4, 2, 2)); 

        // Cargar las imágenes de los jugadores
        imagenX = new ImageIcon(getClass().getResource("/images/JugarCuatriki/X.png")); 
        imagenO = new ImageIcon(getClass().getResource("/images/JugarCuatriki/O.png")); 

        // Crear los botones para el tablero
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                JButton boton = new JButton();
                boton.setContentAreaFilled(false);
                boton.setBorderPainted(false);
                boton.setFocusPainted(false);
                botones[r][c] = boton; 
                add(boton); // Añadir el botón al panel
            }
        }

        setVisible(true);
    }

    // Métodos para obtener las imágenes de los jugadores
    public ImageIcon getImagenX() {
        return imagenX;
    }

    public ImageIcon getImagenO() {
        return imagenO;
    }

    public JButton[][] getBotones() {
        return botones; // Devuelve la matriz de botones
    }
}
