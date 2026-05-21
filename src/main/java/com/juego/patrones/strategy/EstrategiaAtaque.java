package com.juego.patrones.strategy;

import com.juego.model.Personaje;


public interface EstrategiaAtaque {
    void atacar(Personaje atacante, Personaje defensor);
}
