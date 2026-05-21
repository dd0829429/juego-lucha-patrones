package com.juego.juego;

import com.juego.model.Personaje;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JuegoLuchaTest {

    @Mock Personaje jugador1, jugador2;

    private final ByteArrayOutputStream outCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testConstructor() {
        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        assertNotNull(juego);
    }

    @Test
    void testIniciar_GanaJugador1() {
        when(jugador1.getNombre()).thenReturn("A");
        when(jugador2.getNombre()).thenReturn("B");
        when(jugador1.estaVivo()).thenReturn(true, true);
        when(jugador2.estaVivo()).thenReturn(true, false, false);
        when(jugador2.getPuntosDeVida()).thenReturn(100, 0);

        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        juego.iniciar();

        verify(jugador1, times(1)).atacar(jugador2);
        verify(jugador2, never()).atacar(jugador1);
        String output = outCaptor.toString();
        assertTrue(output.contains("GANADOR: A !!!"));
    }

    @Test
    void testIniciar_GanaJugador2() {
        when(jugador1.getNombre()).thenReturn("A");
        when(jugador2.getNombre()).thenReturn("B");
        when(jugador1.estaVivo()).thenReturn(true, false);
        when(jugador2.estaVivo()).thenReturn(true, true, true);
        when(jugador1.getPuntosDeVida()).thenReturn(100, 0);

        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        juego.iniciar();

        verify(jugador1, times(1)).atacar(jugador2);
        verify(jugador2, times(1)).atacar(jugador1);
        String output = outCaptor.toString();
        assertTrue(output.contains("GANADOR: B !!!"));
    }

    @Test
    void testMainMethod() {
        // No usamos mock aquí porque el main crea objetos reales.
        // Simplemente verificamos que no lanza excepción.
        assertDoesNotThrow(() -> JuegoLucha.main(null));
        String output = outCaptor.toString();
        assertTrue(output.contains("COMBATE:") && output.contains("GANADOR:"));
    }
}