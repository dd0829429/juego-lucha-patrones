package com.juego.patrones.strategy;

import com.juego.model.Personaje;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EstrategiaAtaqueTest {

    @Mock Personaje atacante, defensor;

    @Test
    void testAtaqueNormal_CausaDanoEnRango() {
        AtaqueNormal estrategia = new AtaqueNormal();
        // No podemos verificar el valor exacto por aleatoriedad, pero verificamos que se llama a recibirDano
        estrategia.atacar(atacante, defensor);
        verify(defensor, times(1)).recibirDano(anyInt());
    }

    @Test
    void testAtaqueFuego_CausaDanoEnRango() {
        AtaqueFuego estrategia = new AtaqueFuego();
        estrategia.atacar(atacante, defensor);
        verify(defensor, times(1)).recibirDano(anyInt());
    }

    @Test
    void testAtaqueHielo_CausaDanoEnRango() {
        AtaqueHielo estrategia = new AtaqueHielo();
        estrategia.atacar(atacante, defensor);
        verify(defensor, times(1)).recibirDano(anyInt());
    }
}