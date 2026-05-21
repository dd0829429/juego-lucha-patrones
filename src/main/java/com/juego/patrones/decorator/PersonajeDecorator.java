package com.juego.patrones.decorator;

import com.juego.model.Personaje;

public abstract class PersonajeDecorator extends Personaje {

    protected Personaje personaje; 

    public PersonajeDecorator(Personaje personaje) {
        super(personaje.getNombre()); 
        this.personaje = personaje;
    }

    
    @Override
    public void atacar(Personaje oponente) {
        personaje.atacar(oponente);
    }

    @Override
    public void recibirDano(int dano) {
        personaje.recibirDano(dano);
    }

    @Override
    public boolean estaVivo() {
        return personaje.estaVivo();
    }

    @Override
    public int getPuntosDeVida() {
        return personaje.getPuntosDeVida();
    }
}
