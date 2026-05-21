package com.juego.patrones.factory;

import com.juego.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void testGuerreroFactory() {
        PersonajeFactory factory = new GuerreroFactory();
        Personaje p = factory.crearPersonaje();
        assertTrue(p instanceof Guerrero);
        assertEquals("Guerrero", p.getNombre());
        assertEquals(100, p.getPuntosDeVida());
        assertTrue(p.getEstrategia() instanceof com.juego.patrones.strategy.AtaqueNormal);
    }

    @Test
    void testMagoFactory() {
        PersonajeFactory factory = new MagoFactory();
        Personaje p = factory.crearPersonaje();
        assertTrue(p instanceof Mago);
        assertEquals("Mago", p.getNombre());
        assertTrue(p.getEstrategia() instanceof com.juego.patrones.strategy.AtaqueFuego);
    }

    @Test
    void testArqueroFactory() {
        PersonajeFactory factory = new ArqueroFactory();
        Personaje p = factory.crearPersonaje();
        assertTrue(p instanceof Arquero);
        assertEquals("Arquero", p.getNombre());
        assertTrue(p.getEstrategia() instanceof com.juego.patrones.strategy.AtaqueHielo);
    }
}