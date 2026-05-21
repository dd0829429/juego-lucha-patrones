package com.juego.model;

import com.juego.patrones.strategy.AtaqueNormal;

/**
 * Guerrero: extiende Personaje del codigo original.
 * Usa AtaqueNormal (igual que el Personaje original).
 */
public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre);                        // llama al constructor original
        setEstrategia(new AtaqueNormal());    // configura su estrategia
    }
}
