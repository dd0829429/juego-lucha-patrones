package com.juego.patrones.factory;

import com.juego.model.Guerrero;
import com.juego.model.Personaje;


public class GuerreroFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje() {
        return new Guerrero("Guerrero");
    }
}
