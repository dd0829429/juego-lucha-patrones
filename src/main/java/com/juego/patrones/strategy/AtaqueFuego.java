package com.juego.patrones.strategy;

import com.juego.model.Personaje;
import java.util.Random;


public class AtaqueFuego implements EstrategiaAtaque {
    private final Random rand = new Random();

    @Override
    public void atacar(Personaje atacante, Personaje defensor) {
        int dano = rand.nextInt(26) + 25; 
        defensor.recibirDano(dano);
        System.out.println(atacante.getNombre() + " lanza fuego a " + defensor.getNombre()
            + " causando " + dano + " puntos de danio.");
    }
}
