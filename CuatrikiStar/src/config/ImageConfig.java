package config;

import java.awt.Color;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageConfig {

    private ImageIcon Fondo;
    private ImageIcon StartButton;

    public ImageConfig() {
        // Constructor sin implementación por ahora, se invoca el método dibujarFondo desde fuera
    }

    // Método que dibuja el fondo en el panel pasado como argumento
    public void dibujarFondo(JPanel panel) {
        try {
            // Intentar cargar la imagen
            Fondo = new ImageIcon(getClass().getResource("/images/PanelInicio/FONDO.png"));

            // Verificar si la imagen se cargó correctamente
            if (Fondo == null || Fondo.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
                throw new IOException("No se encontró la imagen en la ruta especificada o hubo un error de carga.");
            }

            // Crear y configurar el JLabel con la imagen de fondo
            JLabel labelFondo = new JLabel(Fondo);
            labelFondo.setBounds(0, 0, 1300, 900);  // Ajusta según las dimensiones del panel
            panel.setLayout(null);  // Asegurarse de que el layout sea null para el posicionamiento
            panel.add(labelFondo);

        } catch (IOException e) {
            // Manejar el error y establecer un fondo de color sólido si no se encuentra la imagen
            e.printStackTrace();
            panel.setBackground(new Color(200, 200, 200)); // Color sólido por defecto en caso de error
        } catch (Exception e) {
            // Manejar cualquier otro error inesperado
            e.printStackTrace();
            panel.setBackground(new Color(255, 0, 0)); // Establecer un fondo rojo para indicar un error grave
        }
    }
    
    public void dibujarBotonPlay(JPanel panel) {
		
	}

    public ImageIcon getFondo() {
        return Fondo;
    }
}
