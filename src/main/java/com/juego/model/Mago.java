package com.juego.model;

import com.juego.patrones.strategy.AtaqueFuego;

/**
 * Mago: extiende Personaje del codigo original.
 * Usa AtaqueFuego — hace mas dano que un guerrero.
 */
public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre);
        setEstrategia(new AtaqueFuego());
    }
}
