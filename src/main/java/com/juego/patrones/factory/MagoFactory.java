package com.juego.patrones.factory;

import com.juego.model.Mago;
import com.juego.model.Personaje;

/** Crea un Mago. Ya viene con AtaqueFuego. */
public class MagoFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje() {
        return new Mago("Mago");
    }
}
