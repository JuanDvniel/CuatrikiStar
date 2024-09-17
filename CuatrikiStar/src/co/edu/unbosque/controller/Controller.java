package co.edu.unbosque.controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import co.edu.unbosque.model.CasillaOcupadaException;
import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.JuegoTerminadoException;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.persistence.PersistenciaJuego;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {

    private VentanaPrincipal ventanaPrincipal;
    private Juego juego;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean turnoJugador; // true para Jugador X, false para Jugador O
    private int movimientosRealizados;

    public Controller() {
        ventanaPrincipal = new VentanaPrincipal();
        movimientosRealizados = 0;
        turnoJugador = true; // El juego empieza con el Jugador X
        asignarOyentes(); // Asignar oyentes a los botones
    }

    public void asignarOyentes() {
        ventanaPrincipal.getpInicio().getStartButton().addActionListener(e -> abrirPantallaRegistro());
        ventanaPrincipal.getpInicio().getGameHistoryButton().addActionListener(e -> abrirPantallaHistorialPartidas());
        ventanaPrincipal.getrJugador().getPlayButton().addActionListener(e -> irAJugar());
        ventanaPrincipal.getrJugador().getGuardarJugador1().addActionListener(e -> guardarJugador());
        ventanaPrincipal.getrJugador().getGuardarJugador2().addActionListener(e -> guardarJugador());
        ventanaPrincipal.getjCuatriki().getBackMenuButton().addActionListener(e -> backToMenu());
        ventanaPrincipal.getjCuatriki().getGameHButton().addActionListener(e -> abrirPantallaHistorialPartidas());
        ventanaPrincipal.getjCuatriki().getRestartButton().addActionListener(e -> reiniciarTablero());
        ventanaPrincipal.gethPartidas().getBackMenuButton().addActionListener(e -> backToMenu());
        ventanaPrincipal.gethPartidas().getBackToGame().addActionListener(e -> backToGame());

        // Asignar oyentes a los botones del tablero
        asignarOyentesTablero();
    }

    private void guardarJugador() {
        String nombre1 = ventanaPrincipal.getrJugador().getNombreJugador1().getText();
        String nombre2 = ventanaPrincipal.getrJugador().getNombreJugador2().getText();

        jugador1 = new Jugador(nombre1, 'x');
        jugador2 = new Jugador(nombre2, 'o');

        System.out.println(jugador1);
        System.out.println(jugador2);
    }

    private void asignarOyentesTablero() {
        JButton[][] botones = ventanaPrincipal.getjCuatriki().getMatrizDeJuego().getBotones();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int fila = i;
                final int columna = j;

                // Añadir oyente a cada botón del tablero
                botones[fila][columna].addActionListener(e -> manejarMovimiento(fila, columna, botones[fila][columna]));
            }
        }
    }

    private void manejarMovimiento(int fila, int columna, JButton boton) {
        try {
            if (boton.getIcon() == null) { 
                char jugadorActual = turnoJugador ? 'X' : 'O';
                boton.setIcon(turnoJugador ? ventanaPrincipal.getjCuatriki().getMatrizDeJuego().getImagenX() : ventanaPrincipal.getjCuatriki().getMatrizDeJuego().getImagenO());
                juego.jugarTurno(turnoJugador ? jugador1 : jugador2, fila, columna);

                // Registro del movimiento en la consola
                actualizarConsola("Jugador " + jugadorActual + " ha movido en la posición (" + fila + ", " + columna + ")\n");

                turnoJugador = !turnoJugador; 
                movimientosRealizados++;

                if (juego.isJuegoTerminado()) {
                    String resultado = juego.getGanador() != null ? "¡" + juego.getGanador().getNombre() + " ha ganado!" : "¡El juego ha terminado en empate!";
                    JOptionPane.showMessageDialog(null, resultado);
                    actualizarConsola(resultado + "\n");
                    finalizarJuego();
                    reiniciarTablero();
                } else if (movimientosRealizados == 16) {
                    String empateMsg = "¡Es un empate!";
                    JOptionPane.showMessageDialog(null, empateMsg);
                    actualizarConsola(empateMsg + "\n");
                    finalizarJuego();
                    reiniciarTablero();
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Esa casilla ya está ocupada!");
                actualizarConsola("Intento de mover en una casilla ocupada (" + fila + ", " + columna + ")\n");
            }
        } catch (CasillaOcupadaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            actualizarConsola("Error: " + e.getMessage() + "\n");
        } catch (JuegoTerminadoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            actualizarConsola("Error: " + e.getMessage() + "\n");
        }
    }

    public void actualizarConsola(String texto) {
        JTextArea consola = ventanaPrincipal.getjCuatriki().getConsola();
        consola.append(texto);
    }





	private void abrirPantallaRegistro() {
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.getrJugador());
    }

	public void abrirPantallaHistorialPartidas() {
	    ventanaPrincipal.mostrarPanel(ventanaPrincipal.gethPartidas());
	    HistorialController historialController = new HistorialController(ventanaPrincipal.gethPartidas());
	    historialController.cargarHistorial();
	}


    private void irAJugar() {
        if (jugador1 == null || jugador2 == null) {
            JOptionPane.showMessageDialog(null, "Regrese y registre su usuario para jugar");
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.getrJugador());
            return; 
        }
        
        juego = new Juego(jugador1, jugador2);
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.getjCuatriki()); 
    }

    private void finalizarJuego() {
        if (juego.isJuegoTerminado()) {
            PersistenciaJuego persistencia = new PersistenciaJuego();
            persistencia.guardarPartida(juego);
            JOptionPane.showMessageDialog(null, "Partida guardada correctamente.");
        }
    }


    private void backToMenu() {
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.getpInicio());
    }

    private void backToGame() {
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.getjCuatriki());
    }

    private void reiniciarTablero() {
        JButton[][] botones = ventanaPrincipal.getjCuatriki().getMatrizDeJuego().getBotones();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                botones[i][j].setIcon(null); 
            }
        }
        movimientosRealizados = 0;
        turnoJugador = true; 
        juego.reiniciarJuego(); 
    }
    
}

