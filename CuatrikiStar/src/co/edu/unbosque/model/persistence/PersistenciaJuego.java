package co.edu.unbosque.model.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Juego;


public class PersistenciaJuego {

    private static final String FILENAME = "historial_partidas.txt"; 

    public void guardarPartida(Juego juego) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bw.write("Partida entre " + juego.getJugador1().getNombre() + " y " + juego.getJugador2().getNombre());
            bw.newLine();
            bw.write("Ganador: " + (juego.getGanador() != null ? juego.getGanador().getNombre() : "Empate"));
            bw.newLine();
            bw.write("Tablero final:");
            bw.newLine();
            for (char[] fila : juego.getTablero()) {
                for (char c : fila) {
                    bw.write(c + ' ');
                }
                bw.newLine();
            }
            bw.flush(); 
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de historial: " + e.getMessage());
        }
    }

    public List<String> leerHistorial() throws IOException {
        List<String> historial = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                historial.add(linea);
            }
        }
        return historial;
    }
    
}
