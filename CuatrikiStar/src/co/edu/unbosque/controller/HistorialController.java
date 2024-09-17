package co.edu.unbosque.controller;



import java.io.IOException;
import java.util.List;

import co.edu.unbosque.model.persistence.PersistenciaJuego;
import co.edu.unbosque.view.HistorialPartidas;
import co.edu.unbosque.view.VentanaPrincipal;

public class HistorialController {
	private VentanaPrincipal ventanaPrincipal;
    private HistorialPartidas vistaHistorial;
    private PersistenciaJuego gestorHistorial;

    public HistorialController(HistorialPartidas vistaHistorial) {
        this.vistaHistorial = vistaHistorial;
        this.gestorHistorial = new PersistenciaJuego();
    }

    public void cargarHistorial() {
        try {
            List<String> historial = gestorHistorial.leerHistorial();
            vistaHistorial.mostrarHistorial(historial);
        } catch (IOException e) {
            vistaHistorial.mostrarError("Error al cargar el historial: " + e.getMessage());
        }
    }
    private void abrirPantallaHistorialPartidas() {
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.gethPartidas());
        HistorialController historialController = new HistorialController(ventanaPrincipal.gethPartidas());
        historialController.cargarHistorial();
    }

}

