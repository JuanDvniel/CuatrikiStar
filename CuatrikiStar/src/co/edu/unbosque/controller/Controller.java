package co.edu.unbosque.controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Juego;
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
                if (turnoJugador) {
                    boton.setIcon(ventanaPrincipal.getjCuatriki().getMatrizDeJuego().getImagenX()); 
                    juego.jugarTurno(jugador1, fila, columna); // Actualizar el modelo
                } else {
                    boton.setIcon(ventanaPrincipal.getjCuatriki().getMatrizDeJuego().getImagenO()); 
                    juego.jugarTurno(jugador2, fila, columna); // Actualizar el modelo
                }

                turnoJugador = !turnoJugador; 
                movimientosRealizados++;

                if (juego.isJuegoTerminado()) {
                    JOptionPane.showMessageDialog(null, "¡El juego ha terminado!");
                    finalizarJuego(); 
                    reiniciarTablero();
                } else if (movimientosRealizados == 16) {
                    JOptionPane.showMessageDialog(null, "¡Es un empate!");
                    finalizarJuego(); 
                    reiniciarTablero();
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Esa casilla ya está ocupada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void abrirPantallaRegistro() {
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.getrJugador());
    }

    private void abrirPantallaHistorialPartidas() {
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.gethPartidas());
    }

    private void irAJugar() {
        if (jugador1 == null || jugador2 == null) {
            JOptionPane.showMessageDialog(null, "Regrese y registre su usuario para jugar");
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.getrJugador());
            return; // Importante retornar para no seguir ejecutando el resto del método
        }
        
        juego = new Juego(jugador1, jugador2);
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.getjCuatriki()); // Mostrar pantalla de juego
    }

    // Este método debería ser llamado cuando el juego concluye, por ejemplo, en algún manejador donde se detecta fin de partida
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

