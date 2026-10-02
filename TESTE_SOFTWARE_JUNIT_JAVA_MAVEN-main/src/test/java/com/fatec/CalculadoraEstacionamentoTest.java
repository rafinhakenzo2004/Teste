package com.fatec;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraEstacionamentoTest {

    @Test
    @DisplayName("O valor da primeira hora deve ser R$10.00")
    void deveSerDez() {
        double resultado = CalculadoraEstacionamento.calcularTarifa(1);
        assertEquals(10.00, resultado, 0.001);
    }

    @Test
    @DisplayName("O valor de 2 horas deve ser R$ 15,00")
    void deveSerQuinze() {
        double resultado = CalculadoraEstacionamento.calcularTarifa(2);
        assertEquals(15.00, resultado, 0.001);
    }

    @Test
    @DisplayName("O valor de 3 horas deve ser R$ 20,00")
    void deveSerVinte() {
        double resultado = CalculadoraEstacionamento.calcularTarifa(3);
        assertEquals(20.00, resultado, 0.001);
    }

    @Test
    @DisplayName("O valor de 4 horas (primeira hora após a 3ª) deve ser R$ 23,00")
    void deveSerVinteETres() {
        double resultado = CalculadoraEstacionamento.calcularTarifa(4);
        assertEquals(23.00, resultado, 0.001);
    }

    @Test
    @DisplayName("O valor de 6 horas deve ser R$ 29,00")
    void deveSerVinteNove() {
        double resultado = CalculadoraEstacionamento.calcularTarifa(6);
        assertEquals(29.00, resultado, 0.001);
    }

    @Test
    @DisplayName("Horas zero não devem ser aceitas")
    void horasZero() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraEstacionamento.calcularTarifa(0));
    }

    @Test
    @DisplayName("Horas negativas não devem ser aceitas")
    void horasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraEstacionamento.calcularTarifa(-12));
    }

    @Test
    @DisplayName("Deve validar a mensagem exata da exceção ao passar tempo inválido")
    void deveValidarMensagemExcecao() {
        IllegalArgumentException excecao = assertThrows(
            IllegalArgumentException.class,
            () -> CalculadoraEstacionamento.calcularTarifa(0)
        );
        assertEquals("O tempo mínimo de permanência é de 1 hora.", excecao.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "1,  10.00",
        "2,  15.00",
        "3,  20.00",
        "4,  23.00",
        "5,  26.00",
        "6,  29.00",
        "10, 41.00"
    })
    @DisplayName("Deve calcular corretamente os valores para múltiplos cenários de permanência")
    void deveValidarMultiplasPermanencias(int horas, double valorEsperado) {
        assertEquals(valorEsperado, CalculadoraEstacionamento.calcularTarifa(horas), 0.001);
    }
}
