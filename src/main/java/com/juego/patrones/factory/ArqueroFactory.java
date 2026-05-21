package com.juego.patrones.factory;

import com.juego.model.Arquero;
import com.juego.model.Personaje;

/** Crea un Arquero. Ya viene con AtaqueHielo. */
public class ArqueroFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje() {
        return new Arquero("Arquero");
    }
}
