package com.juego.model;

import java.util.Random;
import com.juego.patrones.strategy.EstrategiaAtaque;
import com.juego.patrones.strategy.AtaqueNormal;

public class Personaje {
    private String nombre;
    private int puntosDeVida;
    private final int MAX_DANO = 30;   // se conserva del original
    private final int MIN_DANO = 10;   // se conserva del original
    private Random rand;               // se conserva del original

    // NUEVO (Strategy): cada personaje tiene una estrategia de ataque
    private EstrategiaAtaque estrategia;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
        this.rand = new Random();
        this.estrategia = new AtaqueNormal(); // estrategia por defecto
    }

    // MODIFICADO: ahora delega a la estrategia en vez de calcular el dano aqui
    // Antes: int dano = rand.nextInt(MAX_DANO - MIN_DANO + 1) + MIN_DANO;
    // Ahora: la estrategia decide cuanto dano hace
    public void atacar(Personaje oponente) {
        estrategia.atacar(this, oponente);
    }

    // IGUAL AL ORIGINAL — sin cambios
    public void recibirDano(int dano) {
        if (dano < 0) return;
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    // IGUAL AL ORIGINAL — sin cambios
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    // IGUAL AL ORIGINAL — sin cambios
    public String getNombre() {
        return this.nombre;
    }

    // IGUAL AL ORIGINAL — sin cambios
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    // NUEVO (Strategy): permite cambiar el tipo de ataque en cualquier momento
    public void setEstrategia(EstrategiaAtaque estrategia) {
        this.estrategia = estrategia;
    }

    // NUEVO (Strategy): permite consultar la estrategia actual (usado en tests)
    public EstrategiaAtaque getEstrategia() {
        return this.estrategia;
    }

    // NUEVO (Decorator): necesario para que el decorator pueda leer/escribir vida
    protected void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }
}
