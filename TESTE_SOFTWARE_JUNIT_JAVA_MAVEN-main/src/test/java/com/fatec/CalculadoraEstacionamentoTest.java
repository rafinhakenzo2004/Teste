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
		assertEquals(10.00, resultado);
	}
	
	@Test
	@DisplayName("O valor de 3 horas deve ser R$ 20,00")
	void deveSerVinte() {
		double resultado = CalculadoraEstacionamento.calcularTarifa(3);
		assertEquals(20.00, resultado);
	}
	
	@Test
	@DisplayName("O valor de 6 horas deve ser R$ 29,00")
	void deveSerVinteNove() {
		double resultado = CalculadoraEstacionamento.calcularTarifa(6);
		assertEquals(29.00, resultado);
	}
	
	@Test
	@DisplayName("Horas negativas não devem ser aceitas")
	void horasNegativas() {
		assertThrows(IllegalArgumentException.class,() -> CalculadoraEstacionamento.calcularTarifa(-12));
	}
}
