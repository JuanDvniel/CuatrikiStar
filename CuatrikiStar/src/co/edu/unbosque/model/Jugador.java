package co.edu.unbosque.model;

public class Jugador {
    private String nombre;
    private String ficha;

    public Jugador(String nombre, String ficha) {
        this.ficha = ficha;
        this.nombre = nombre;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

}