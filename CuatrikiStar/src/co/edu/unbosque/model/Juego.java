package co.edu.unbosque.model;

public class Juego {
	private char[][] tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private boolean juegoTerminado;

	public Juego(Jugador jugador1, Jugador jugador2) {
		this.tablero = new char[4][4];
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
	
	  public void mostrarTablero() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(tablero[i][j] + " ");
	            }
	            System.out.println();
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

	        // Verificar filas, columnas y diagonales
	        for (int i = 0; i < 3; i++) {
	            if (tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) {
	                return true;
	            }
	            if (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo) {
	                return true;
	            }
	        }

	        if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) {
	            return true;
	        }

	        if (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo) {
	            return true;
	        }

	        return false;
	    }

	    private boolean verificarEmpate() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
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

}
