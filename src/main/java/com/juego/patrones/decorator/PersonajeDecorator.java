package com.juego.patrones.decorator;

import com.juego.model.Personaje;

/**
 * PATRON DECORATOR — clase base.
 *
 * Hereda de Personaje (para poder usarse donde se espera un Personaje)
 * Y contiene un Personaje (para envolver y agregar funcionalidad).
 *
 * No modifica NADA del Personaje original.
 * Solo "envuelve" un personaje existente.
 */
public abstract class PersonajeDecorator extends Personaje {

    protected Personaje personaje; // el personaje que estamos decorando

    public PersonajeDecorator(Personaje personaje) {
        super(personaje.getNombre()); // conserva el nombre original
        this.personaje = personaje;
    }

    // Delega todo al personaje envuelto
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
