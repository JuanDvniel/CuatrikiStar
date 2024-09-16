package co.edu.unbosque.model;

public class Juego {
	
    private char[][] tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean juegoTerminado;

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.tablero = new char[4][4]; // Tablero de 4x4
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juegoTerminado = false;
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public boolean jugarTurno(Jugador jugador, int fila, int columna) throws Exception {
        if (juegoTerminado) {
            throw new Exception("El juego ha terminado. No se pueden hacer más movimientos.");
        }

        if (tablero[fila][columna] != '-') {
            throw new Exception("La casilla ya está ocupada. Elija otra casilla.");
        }

        tablero[fila][columna] = jugador.getFicha();

        if (verificarVictoria(jugador)) {
            juegoTerminado = true;
            System.out.println("¡" + jugador.getNombre() + " ha ganado el juego!");
            return true;
        }

        if (verificarEmpate()) {
            juegoTerminado = true;
            System.out.println("¡El juego ha terminado en empate!");
            return true;
        }

        return false;
    }

    private boolean verificarVictoria(Jugador jugador) {
        char simbolo = jugador.getFicha();

        // Verificar filas
        for (int i = 0; i < 4; i++) {
            if (tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo && tablero[i][3] == simbolo ) {
                return true; 
            }
        }

        // Verificar columnas
        for (int j = 0; j < 4; j++) {
            if (tablero[0][j] == simbolo && tablero[1][j] == simbolo && tablero[2][j] == simbolo && tablero[3][j] == simbolo) {
                return true; // Ganador en la columna
            }
        }

        // Verificar diagonal principal
        if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo && tablero[3][3] == simbolo ) {
            return true;
        }

        // Verificar diagonal inversa
        if (tablero[0][3] == simbolo && tablero[1][2] == simbolo && tablero[2][1] == simbolo && tablero[3][0] == simbolo ) {
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j] == '-') {
                    return false; 
                }
            }
        }
        return true; 
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void reiniciarJuego() {
        inicializarTablero();
        juegoTerminado = false;
    }
    public Jugador getGanador() {
        if (!juegoTerminado) return null;
        if (verificarVictoria(jugador1)) return jugador1;
        if (verificarVictoria(jugador2)) return jugador2;
        return null; // Retorna null si es empate o el juego no ha terminado
    }
    
}

