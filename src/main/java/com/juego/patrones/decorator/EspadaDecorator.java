package com.juego.patrones.decorator;

import com.juego.model.Personaje;

/**
 * EspadaDecorator: agrega 15 puntos de dano extra en cada ataque.
 *
 * Uso:
 *   Personaje p = new EspadaDecorator(new Guerrero("Thor"));
 *   p.atacar(enemigo); // dano del guerrero + 15 extra
 */
public class EspadaDecorator extends PersonajeDecorator {

    private static final int DANO_EXTRA = 15;

    public EspadaDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void atacar(Personaje oponente) {
        personaje.atacar(oponente);              // ataque normal
        oponente.recibirDano(DANO_EXTRA);        // dano extra de la espada
        System.out.println("  [Espada] +" + DANO_EXTRA + " de dano extra!");
    }
}
