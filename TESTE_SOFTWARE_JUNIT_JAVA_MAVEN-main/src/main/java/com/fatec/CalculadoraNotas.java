package com.fatec;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraNotas {

    // Regra de negócio com validações e decisões
    public static String verificarSituacao(double nota1, double nota2) {
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            throw new IllegalArgumentException("As notas devem estar no intervalo de 0.0 a 10.0.");
        }

        double media = (nota1 + nota2) / 2.0;

        if (media >= 7.0) {
            return "APROVADO";
        } else if (media >= 5.0) {
            return "RECUPERACAO";
        } else {
            return "REPROVADO";
        }
    }

    // Método interativo com Scanner e tratamento de exceções
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite a primeira nota: ");
            double n1 = scanner.nextDouble();

            System.out.print("Digite a segunda nota: ");
            double n2 = scanner.nextDouble();

            String situacao = verificarSituacao(n1, n2);
            double media = (n1 + n2) / 2.0;

            System.out.printf("Média: %.2f | Situação: %s\n", media, situacao);

        } catch (InputMismatchException e) {
            System.out.println("Erro de Entrada: Insira apenas números decimais ou inteiros.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de Validação: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}