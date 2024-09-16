package co.edu.unbosque.model.persistence;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.Jugador;

public class PersistenciaJuego {

    private static final String FILENAME = "historial_partidas.txt"; 

    public void guardarPartida(Juego juego) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
           

            bw.write("Partida entre " + juego.getJugador1().getNombre() + " y " + juego.getJugador2().getNombre());
            bw.newLine();
            bw.write("Ganador: " + (juego.isJuegoTerminado() ? (juego.getGanador() != null ? juego.getGanador().getNombre() : "Empate") : "Partida no finalizada"));
            bw.newLine();
            bw.write("Tablero final:");
            bw.newLine();
            for (char[] fila : juego.getTablero()) {
                for (char c : fila) {
                    bw.write(c + " ");
                }
                bw.newLine();
            }
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de historial: " + e.getMessage());
        }
    }
}
