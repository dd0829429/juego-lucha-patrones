package com.juego.patrones.decorator;

import com.juego.model.Personaje;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DecoratorTest {

    @Mock Personaje mockPersonaje;
    @Mock Personaje mockOponente;

    @Test
    void testEspadaDecorator_AumentaDano() {
        EspadaDecorator espada = new EspadaDecorator(mockPersonaje);
        espada.atacar(mockOponente);
        // Verifica que el ataque del decorado llama al ataque del envuelto
        verify(mockPersonaje, times(1)).atacar(mockOponente);
        // Y además aplica daño extra
        verify(mockOponente, times(1)).recibirDano(15);
    }

    @Test
    void testEscudoDecorator_ReduceDano() {
        EscudoDecorator escudo = new EscudoDecorator(mockPersonaje);
        escudo.recibirDano(25);
        verify(mockPersonaje, times(1)).recibirDano(15); // 25 - 10 = 15
    }

    @Test
    void testEscudoDecorator_DanoMenorQueAbsorcion() {
        EscudoDecorator escudo = new EscudoDecorator(mockPersonaje);
        escudo.recibirDano(5);
        verify(mockPersonaje, times(1)).recibirDano(0);
    }

    @Test
    void testMultiplesDecoradores() {
        Personaje decorado = new EspadaDecorator(new EscudoDecorator(mockPersonaje));
        decorado.atacar(mockOponente);
        verify(mockPersonaje, times(1)).atacar(mockOponente);
        verify(mockOponente, times(1)).recibirDano(15);

        decorado.recibirDano(30);
        verify(mockPersonaje, times(1)).recibirDano(20);
    }

    @Test
    void testPersonajeDecorator_DelegaMetodos() {
        when(mockPersonaje.getNombre()).thenReturn("Prueba");
        when(mockPersonaje.getPuntosDeVida()).thenReturn(80);
        when(mockPersonaje.estaVivo()).thenReturn(true);

        PersonajeDecorator decorator = new EspadaDecorator(mockPersonaje);
        assertEquals("Prueba", decorator.getNombre());
        assertEquals(80, decorator.getPuntosDeVida());
        assertTrue(decorator.estaVivo());

        verify(mockPersonaje).getNombre();
        verify(mockPersonaje).getPuntosDeVida();
        verify(mockPersonaje).estaVivo();
    }
}