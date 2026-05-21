package com.juego.patrones.factory;

import com.juego.model.Mago;
import com.juego.model.Personaje;


public class MagoFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje() {
        return new Mago("Mago");
    }
}
