package com.juego.patrones.decorator;

import com.juego.model.Personaje;


public class EscudoDecorator extends PersonajeDecorator {

    private static final int ABSORCION = 10;

    public EscudoDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void recibirDano(int dano) {
        int danoReal = Math.max(0, dano - ABSORCION); 
        System.out.println("  [Escudo] absorbe " + ABSORCION
            + " pts. Dano real: " + danoReal);
        personaje.recibirDano(danoReal);
    }
}
