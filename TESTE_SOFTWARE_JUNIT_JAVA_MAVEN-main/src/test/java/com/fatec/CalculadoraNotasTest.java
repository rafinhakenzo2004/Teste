package com.fatec;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraNotasTest {

    @Test
    @DisplayName("Deve retornar APROVADO quando a média for maior ou igual a 7.0")
    void deveAprovarAluno() {
        String resultado = CalculadoraNotas.verificarSituacao(8.0, 7.0);
        assertEquals("APROVADO", resultado);
    }

    @Test
    @DisplayName("Deve retornar RECUPERACAO quando a média estiver entre 5.0 e 6.9")
    void deveColocarEmRecuperacao() {
        String resultado = CalculadoraNotas.verificarSituacao(6.0, 5.0);
        assertEquals("RECUPERACAO", resultado);
    }

    @Test
    @DisplayName("Deve retornar REPROVADO quando a média for menor que 5.0")
    void deveReprovarAluno() {
        String resultado = CalculadoraNotas.verificarSituacao(4.0, 3.0);
        assertEquals("REPROVADO", resultado);
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a nota 1 for negativa")
    void deveLancarExcecaoNota1Negativa() {
        IllegalArgumentException excecao = assertThrows(
            IllegalArgumentException.class,
            () -> CalculadoraNotas.verificarSituacao(-1000000.0, 8.0)
        );
        assertEquals("As notas devem estar no intervalo de 0.0 a 10.0.", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a nota 1 for maior que 10")
    void deveLancarExcecaoNota1MaiorQueDez() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CalculadoraNotas.verificarSituacao(10.00001, 8.0)
        );
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a nota 2 for negativa")
    void deveLancarExcecaoNota2Negativa() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CalculadoraNotas.verificarSituacao(8.0, -0.1)
        );
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando a nota 2 for maior que 10")
    void deveLancarExcecaoNota2MaiorQueDez() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CalculadoraNotas.verificarSituacao(8.0, 5265216464526.0)
        );
    }

    @ParameterizedTest
    @CsvSource({
        "10.0, 10.0, APROVADO",
        "7.0,  7.0,  APROVADO",
        "6.9,  7.1,  APROVADO",
        "6.9,  5.0,  RECUPERACAO",
        "5.0,  5.0,  RECUPERACAO",
        "4.9,  5.0,  REPROVADO",
        "0.0,  0.0,  REPROVADO"
    })
    @DisplayName("Deve validar limites de borda das notas e médias")
    void deveValidarCasosDeBorda(double nota1, double nota2, String resultadoEsperado) {
        assertEquals(resultadoEsperado, CalculadoraNotas.verificarSituacao(nota1, nota2));
    }
}