package com.juego.juego;

import com.juego.model.Personaje;
import com.juego.patrones.decorator.EspadaDecorator;
import com.juego.patrones.decorator.EscudoDecorator;
import com.juego.patrones.factory.GuerreroFactory;
import com.juego.patrones.factory.MagoFactory;
import com.juego.patrones.factory.PersonajeFactory;


public class JuegoLucha {

    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciar() {
        System.out.println("========================================");
        System.out.println("  COMBATE: "
            + jugador1.getNombre() + " VS " + jugador2.getNombre());
        System.out.println("========================================");

        int turno = 1;
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");

            jugador1.atacar(jugador2);
            System.out.println("  HP " + jugador2.getNombre()
                + ": " + jugador2.getPuntosDeVida());

            if (jugador2.estaVivo()) {
                jugador2.atacar(jugador1);
                System.out.println("  HP " + jugador1.getNombre()
                    + ": " + jugador1.getPuntosDeVida());
            }
            turno++;
        }

        String ganador = jugador1.estaVivo()
            ? jugador1.getNombre()
            : jugador2.getNombre();

        System.out.println("\n========================================");
        System.out.println("  GANADOR: " + ganador + " !!!");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        // FACTORY: 
        PersonajeFactory f1 = new GuerreroFactory();
        PersonajeFactory f2 = new MagoFactory();

        Personaje p1 = f1.crearPersonaje(); 
        Personaje p2 = f2.crearPersonaje(); 

        // DECORATOR
        p1 = new EspadaDecorator(p1);  
        p1 = new EscudoDecorator(p1);  

        // STRATEGY: 

        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciar();
    }
}
