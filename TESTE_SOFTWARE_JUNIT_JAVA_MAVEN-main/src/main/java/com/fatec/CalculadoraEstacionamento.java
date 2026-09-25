package com.fatec;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraEstacionamento {

    // Regra de cálculo de tarifa progressiva
    public static double calcularTarifa(int horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("O tempo mínimo de permanência é de 1 hora.");
        }

        if (horas == 1) {
            return 10.0; // 1ª hora fixa a R$ 10,00
        } else if (horas <= 3) {
            return 10.0 + (horas - 1) * 5.0; // R$ 5,00 por hora adicional até 3h
        } else {
            return 20.0 + (horas - 3) * 3.0; // R$ 3,00 por hora adicional após 3h
        }
    }

    // Execução no console
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe a quantidade de horas no estacionamento: ");
            int horas = scanner.nextInt();

            double total = calcularTarifa(horas);
            System.out.printf("Valor total a pagar: R$ %.2f\n", total);

        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números inteiros para o número de horas.");
        } catch (IllegalArgumentException e) {
            System.out.println("Regra violada: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}