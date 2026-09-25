// Define o pacote da classe de testes, que geralmente espelha a estrutura da classe principal (com.fatec) para facilitar a visibilidade e organização.
package com.fatec;

// Importa os métodos estáticos de asserção do JUnit 5. O 'assertEquals' compara valores e o 'assertTrue' verifica condições booleanas.
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Importa a anotação fundamental que transforma um teste unitário comum em um teste que será executado múltiplas vezes com dados diferentes.
import org.junit.jupiter.params.ParameterizedTest;
// Importa o provedor de dados CSV, ideal para injetar múltiplos parâmetros (variáveis) em uma única execução de teste.
import org.junit.jupiter.params.provider.CsvSource;
// Importa o provedor de dados de valor único, utilizado quando o método testado exige apenas um argumento por vez.
import org.junit.jupiter.params.provider.ValueSource;

// Declara a classe pública que contém o conjunto de testes automatizados para a regra de negócio.
public class CalculadoraTest {

    // Instancia a classe que contém a lógica de negócio a ser testada, deixando-a disponível para todos os métodos desta classe de teste.
    Calculadora calc = new Calculadora();

    // Substitui o @Test tradicional. A propriedade 'name' personaliza a saída no console/relatório, onde {0} é substituído pelo argumento atual.
    @ParameterizedTest(name = "Verificando se {0} é par")
    // Injeta sequencialmente os cinco valores inteiros definidos no array. Isso significa que o método abaixo será executado 5 vezes distintas.
    @ValueSource(ints = {2, 4, 6, 8, 100})
    // Método de teste que recebe, a cada iteração, um valor da anotação @ValueSource através do parâmetro 'numero'.
    void testNumerosPares(int numero) {
        // Invoca o método de negócio e exige que a resposta seja estritamente 'true'. Se o método isNumeroPar retornar 'false', o teste falha imediatamente.
        assertTrue(calc.isNumeroPar(numero));
    }

    // Configura outro teste parametrizado, formatando o nome de exibição no relatório utilizando as posições {0}, {1} e {2} referentes aos argumentos.
    @ParameterizedTest(name = "Compra de {0} com {1}% de desconto = {2}")
    // Fornece uma matriz de dados em formato de texto. Cada string representa uma linha de teste, com valores separados por vírgula mapeando para os parâmetros do método.
    @CsvSource({
        "100, 10, 90",    // Iteração 1: valorTotal=100, desconto=10, resultadoEsperado=90
        "500, 20, 400",   // Iteração 2
        "50, 50, 25",     // Iteração 3
        "1000, 0, 1000"   // Iteração 4: Testa o comportamento limite com 0% de desconto
    })
    // A assinatura do método deve ter exatamente o mesmo número e tipo de parâmetros correspondentes aos dados de cada linha do @CsvSource.
    void testCalcularDesconto(int valorTotal, int desconto, int resultadoEsperado) {
        // Executa o método sob teste (subject under test) passando os valores de entrada e armazena o que o sistema realmente calculou.
        int resultadoReal = calc.calcularDesconto(valorTotal, desconto);
        // Valida se o comportamento da regra de negócio corresponde à expectativa. O teste só passa se o resultado esperado for matematicamente idêntico ao resultado real.
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
