package com.juego.patrones.strategy;

import com.juego.model.Personaje;

/**
 * PATRON STRATEGY
 * Interfaz que define como se comporta un ataque.
 * Cada clase concreta implementa un tipo diferente.
 */
public interface EstrategiaAtaque {
    void atacar(Personaje atacante, Personaje defensor);
}
