package com.juego.model;

import com.juego.patrones.strategy.AtaqueNormal;


public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre);                        
        setEstrategia(new AtaqueNormal());    
    }
}
