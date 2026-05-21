package com.juego.model;

import com.juego.patrones.strategy.AtaqueFuego;


public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre);
        setEstrategia(new AtaqueFuego());
    }
}
