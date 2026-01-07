package br.com.alura.conversor;

import java.util.Map;

public class ConversorMoeda {

    public double converter(int opcao, double valor) {

        ApiExchange api = new ApiExchange();
        ExchangeResponse response = api.buscarTaxas();
        Map<String, Double> taxas = response.getConversion_rates();

        double usdToBrl = taxas.get("BRL");
        double usdToEur = taxas.get("EUR");
        double usdToArs = taxas.get("ARS");

        return switch (opcao) {
            case 1 -> valor * usdToBrl;                 // USD → BRL
            case 2 -> valor / usdToBrl;                 // BRL → USD
            case 3 -> valor * usdToEur;                 // USD → EUR
            case 4 -> (valor / usdToEur) * usdToBrl;    // EUR → BRL
            case 5 -> valor * usdToArs;                 // USD → ARS
            default -> 0;
        };
    }
}

