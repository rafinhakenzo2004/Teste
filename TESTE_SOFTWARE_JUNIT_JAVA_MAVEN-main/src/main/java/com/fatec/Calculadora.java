// Define o pacote da classe, organizando os ficheiros dentro da estrutura do projeto (com.fatec).
package com.fatec;

// Declara a classe pública Calculadora, que encapsula as regras de negócio que serão alvo dos testes unitários.
public class Calculadora {

    // Declara o método público 'isNumeroPar', que recebe um número inteiro como parâmetro e devolve um valor booleano.
    public boolean isNumeroPar(int numero) {
        // Utiliza o operador módulo (%) para verificar se o resto da divisão do número por 2 é igual a zero. Devolve true se for par, false se for ímpar.
        return numero % 2 == 0;
    }

    // Declara o método público 'calcularDesconto', que recebe o valor total e a percentagem de desconto (ambos inteiros) e devolve o valor final.
    public int calcularDesconto(int valorTotal, int percentualDesconto) {
        // Estrutura condicional que valida se a percentagem de desconto fornecida está fora do intervalo lógico permitido (menor que 0 ou maior que 100).
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            // Interrompe imediatamente a execução do método e lança uma exceção, avisando que o argumento passado é inválido.
            throw new IllegalArgumentException("Desconto inválido");
        }
        // Calcula o montante do desconto (valorTotal * percentualDesconto / 100) e subtrai esse montante ao valor total original, devolvendo o resultado.
        return valorTotal - (valorTotal * percentualDesconto / 100);
    }
}