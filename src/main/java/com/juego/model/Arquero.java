package com.juego.model;

import com.juego.patrones.strategy.AtaqueHielo;

/**
 * Arquero: extiende Personaje del codigo original.
 * Usa AtaqueHielo.
 */
public class Arquero extends Personaje {

    public Arquero(String nombre) {
        super(nombre);
        setEstrategia(new AtaqueHielo());
    }
}
