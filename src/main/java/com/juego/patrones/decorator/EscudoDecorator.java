package com.juego.patrones.decorator;

import com.juego.model.Personaje;

/**
 * EscudoDecorator: absorbe 10 puntos de cada golpe recibido.
 *
 * Uso:
 *   Personaje p = new EscudoDecorator(new Guerrero("Thor"));
 *   p.recibirDano(30); // recibe solo 20 en vez de 30
 */
public class EscudoDecorator extends PersonajeDecorator {

    private static final int ABSORCION = 10;

    public EscudoDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void recibirDano(int dano) {
        int danoReal = Math.max(0, dano - ABSORCION); // nunca negativo
        System.out.println("  [Escudo] absorbe " + ABSORCION
            + " pts. Dano real: " + danoReal);
        personaje.recibirDano(danoReal);
    }
}
