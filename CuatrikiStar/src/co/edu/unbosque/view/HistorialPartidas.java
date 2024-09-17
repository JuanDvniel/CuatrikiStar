package co.edu.unbosque.view;

import java.awt.Color;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import config.FontConfig;

public class HistorialPartidas extends JPanel {

    private JButton backMenuButton;
    private JButton backToGame;
    private JTextArea ConsolaHistorial;
    private JScrollPane scrollHistorial; 
    private FontConfig fontConfig;  

    public HistorialPartidas() {
        setBounds(0, 0, 975, 675);
        setBackground(null);
        setLayout(null);
        setVisible(true);

        fontConfig = new FontConfig(); 

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        backMenuButton = new JButton();
        backMenuButton.setBounds(548, 596, 307, 77);
        backMenuButton.setContentAreaFilled(false);
        backMenuButton.setBorderPainted(false);
        backMenuButton.setFocusPainted(false);
        add(backMenuButton);

        backToGame = new JButton();
        backToGame.setBounds(103, 596, 326, 77);
        backToGame.setContentAreaFilled(false);
        backToGame.setBorderPainted(false);
        backToGame.setFocusPainted(false);
        add(backToGame);

        // Donde se mostrará la consola
        ConsolaHistorial = new JTextArea();
        ConsolaHistorial.setEditable(false); // No editable
        ConsolaHistorial.setOpaque(false);
        ConsolaHistorial.setBorder(new EmptyBorder(0, 0, 0, 0));
        ConsolaHistorial.setFont(fontConfig.getFuentePersonalizada());
        ConsolaHistorial.setForeground(new Color(237, 15, 255));

        // JScrollPane para permitir scroll en el JTextArea
        scrollHistorial = new JScrollPane(ConsolaHistorial, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollHistorial.setBounds(53, 252, 875, 307); // Ajusta el tamaño y posición
        scrollHistorial.setOpaque(false);
        scrollHistorial.getViewport().setOpaque(false); // Hacer el viewport del JScrollPane transparente
        scrollHistorial.setBorder(new EmptyBorder(0, 0, 0, 0)); // Sin bordes
        
        // Hacer invisibles las barras de desplazamiento
        JScrollBar verticalScrollBar = scrollHistorial.getVerticalScrollBar();
        verticalScrollBar.setPreferredSize(new java.awt.Dimension(0, 0)); // Oculta la barra vertical

        JScrollBar horizontalScrollBar = scrollHistorial.getHorizontalScrollBar();
        horizontalScrollBar.setPreferredSize(new java.awt.Dimension(0, 0)); // Oculta la barra horizontal

        add(scrollHistorial); // Agregamos el JScrollPane

        JLabel labelBackGame = new JLabel(new ImageIcon(getClass().getResource("/images/HistorialPartidas/BACK TO GAME.png")));
        labelBackGame.setBounds(103, 596, 326, 77);
        add(labelBackGame);

        JLabel labelBackMenu = new JLabel(new ImageIcon(getClass().getResource("/images/JugarCuatriki/BACK TO MENU.png")));
        labelBackMenu.setBounds(548, 596, 307, 77);
        add(labelBackMenu);

        ImageIcon FondoHistorial = new ImageIcon(getClass().getResource("/images/HistorialPartidas/HistorialBack.png"));
        JLabel labelFondoHistorial = new JLabel(FondoHistorial);
        labelFondoHistorial.setBounds(0, 0, 975, 675);
        add(labelFondoHistorial);
    }

    public void mostrarHistorial(List<String> historial) {
        ConsolaHistorial.setText("");  // Limpiar contenido previo
        for (String linea : historial) {
            ConsolaHistorial.append(linea + "\n");
        }
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
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
