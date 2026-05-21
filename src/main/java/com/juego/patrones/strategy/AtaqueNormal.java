package com.juego.patrones.strategy;

import com.juego.model.Personaje;
import java.util.Random;

/**
 * Replica EXACTA de la logica original de Personaje.atacar()
 * Dano aleatorio entre 10 y 30, igual que el codigo base.
 */
public class AtaqueNormal implements EstrategiaAtaque {
    private final Random rand = new Random();

    @Override
    public void atacar(Personaje atacante, Personaje defensor) {
        int MAX_DANO = 30;
        int MIN_DANO = 10;
        int dano = rand.nextInt(MAX_DANO - MIN_DANO + 1) + MIN_DANO;
        defensor.recibirDano(dano);
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre()
            + " causando " + dano + " puntos de danio.");
    }
}
