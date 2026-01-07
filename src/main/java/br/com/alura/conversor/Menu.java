package br.com.alura.conversor;

import java.util.Scanner;
import java.util.Locale;

public class Menu {

    public void exibirMenu() {
        Scanner leitura = new Scanner(System.in).useLocale(Locale.US);
        ConversorMoeda conversor = new ConversorMoeda();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("""
                    
                    ===============================
                    CONVERSOR DE MOEDAS
                    ===============================
                    1 - USD → BRL
                    2 - BRL → USD
                    3 - USD → EUR
                    4 - EUR → BRL
                    5 - USD → ARS
                    6 - Sair
                    ===============================
                    Escolha uma opção:
                    """);

            opcao = leitura.nextInt();

            if (opcao >= 1 && opcao <= 5) {
                System.out.println("Digite o valor:");
                double valor = leitura.nextDouble();

                double resultado = conversor.converter(opcao, valor);
                System.out.println("Valor convertido: " + resultado);
            } else if (opcao != 6) {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Programa encerrado.");
        leitura.close();
    }
}
