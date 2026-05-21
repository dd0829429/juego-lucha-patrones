package com.juego.patrones.decorator;

import com.juego.model.Personaje;


public class EspadaDecorator extends PersonajeDecorator {

    private static final int DANO_EXTRA = 15;

    public EspadaDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void atacar(Personaje oponente) {
        personaje.atacar(oponente);              
        oponente.recibirDano(DANO_EXTRA);        
        System.out.println("  [Espada] +" + DANO_EXTRA + " de dano extra!");
    }
}
