package com.juego.patrones.factory;

import com.juego.model.Personaje;

/**
 * PATRON FACTORY METHOD — interfaz de fabrica.
 * Define el contrato: toda factory crea un Personaje.
 */
public interface PersonajeFactory {
    Personaje crearPersonaje();
}
