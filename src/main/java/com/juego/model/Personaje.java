package com.juego.model;

import java.util.Random;
import com.juego.patrones.strategy.EstrategiaAtaque;
import com.juego.patrones.strategy.AtaqueNormal;

public class Personaje {
    private String nombre;
    private int puntosDeVida;
    private final int MAX_DANO = 30;   
    private final int MIN_DANO = 10;  
    private Random rand;               

    
    private EstrategiaAtaque estrategia;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
        this.rand = new Random();
        this.estrategia = new AtaqueNormal(); 
    }

 
    public void atacar(Personaje oponente) {
        estrategia.atacar(this, oponente);
    }

    
    public void recibirDano(int dano) {
        if (dano < 0) return;
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

  
    public String getNombre() {
        return this.nombre;
    }

    
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    
    public void setEstrategia(EstrategiaAtaque estrategia) {
        this.estrategia = estrategia;
    }

    
    public EstrategiaAtaque getEstrategia() {
        return this.estrategia;
    }

    
    protected void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }
}
