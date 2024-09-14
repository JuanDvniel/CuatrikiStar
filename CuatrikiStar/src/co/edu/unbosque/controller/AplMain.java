package co.edu.unbosque.controller;



public class AplMain {

	public static void main(String[] args) {

		Controller control;
		control = new Controller();
		/*
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingrese el nombre del Jugador 1 (X): ");
	        String nombre1 = scanner.nextLine();
	        Jugador jugador1 = new Jugador(nombre1, 'X');

	        System.out.println("Ingrese el nombre del Jugador 2 (O): ");
	        String nombre2 = scanner.nextLine();
	        Jugador jugador2 = new Jugador(nombre2, 'O');

	        Juego juego = new Juego(jugador1, jugador2);
	        boolean turnoJugador1 = true;

	        while (!juego.isJuegoTerminado()) {
	            juego.mostrarTablero();

	            Jugador jugadorActual = turnoJugador1 ? jugador1 : jugador2;
	            System.out.println(jugadorActual.getNombre() + " (" + jugadorActual.getFicha() + ") elija fila (0-2): ");
	            int fila = scanner.nextInt();
	            System.out.println(jugadorActual.getNombre() + " (" + jugadorActual.getFicha() + ") elija columna (0-2): ");
	            int columna = scanner.nextInt();

	            try {
	                juego.jugarTurno(jugadorActual, fila, columna);
	                turnoJugador1 = !turnoJugador1;
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }

	        juego.mostrarTablero();
	        System.out.println("Fin del juego.");
	    
		 */

	}
}