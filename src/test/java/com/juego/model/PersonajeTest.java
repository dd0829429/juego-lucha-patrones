package com.juego.model;

import com.juego.patrones.strategy.AtaqueNormal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    @Test
    void testConstructorYGetters() {
        Personaje p = new Personaje("Thor");
        assertEquals("Thor", p.getNombre());
        assertEquals(100, p.getPuntosDeVida());
        assertTrue(p.estaVivo());
        assertNotNull(p.getEstrategia());
        assertTrue(p.getEstrategia() instanceof AtaqueNormal);
    }

    @Test
    void testRecibirDano_ReduceVida() {
        Personaje p = new Personaje("Thor");
        p.recibirDano(30);
        assertEquals(70, p.getPuntosDeVida());
    }

    @Test
    void testRecibirDano_NoBajaDeCero() {
        Personaje p = new Personaje("Thor");
        p.recibirDano(150);
        assertEquals(0, p.getPuntosDeVida());
        assertFalse(p.estaVivo());
    }

    @Test
    void testRecibirDano_DanoNegativo_NoCambia() {
        Personaje p = new Personaje("Thor");
        p.recibirDano(-10);
        assertEquals(100, p.getPuntosDeVida());
    }

    @Test
    void testSetEstrategia() {
        Personaje p = new Personaje("Mago");
        assertTrue(p.getEstrategia() instanceof AtaqueNormal);
        p.setEstrategia(new com.juego.patrones.strategy.AtaqueFuego());
        assertTrue(p.getEstrategia() instanceof com.juego.patrones.strategy.AtaqueFuego);
    }

    @Test
    void testGuerrero_TieneAtaqueNormal() {
        Guerrero g = new Guerrero("Ares");
        assertTrue(g.getEstrategia() instanceof AtaqueNormal);
    }

    @Test
    void testMago_TieneAtaqueFuego() {
        Mago m = new Mago("Merlin");
        assertTrue(m.getEstrategia() instanceof com.juego.patrones.strategy.AtaqueFuego);
    }

    @Test
    void testArquero_TieneAtaqueHielo() {
        Arquero a = new Arquero("Legolas");
        assertTrue(a.getEstrategia() instanceof com.juego.patrones.strategy.AtaqueHielo);
    }
}