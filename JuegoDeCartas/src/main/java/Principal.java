import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Persona jugador1 = new Persona("juanito");
        Persona jugador2 = new Persona("pedrito");
        Baraja b1 = new Baraja(1);
        Juego salaJuego = new Juego(jugador1,jugador2, b1);

    }
}
