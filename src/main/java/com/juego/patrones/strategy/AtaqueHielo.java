package com.juego.patrones.strategy;

import com.juego.model.Personaje;
import java.util.Random;


public class AtaqueHielo implements EstrategiaAtaque {
    private final Random rand = new Random();

    @Override
    public void atacar(Personaje atacante, Personaje defensor) {
        int dano = rand.nextInt(21) + 15; // 15 a 35
        defensor.recibirDano(dano);
        System.out.println(atacante.getNombre() + " congela a " + defensor.getNombre()
            + " causando " + dano + " puntos de danio. ¡Congelado!");
    }
}
