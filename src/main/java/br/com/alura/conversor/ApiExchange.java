package br.com.alura.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchange {

    private static final String API_KEY = "37d58554653212c43c82a072";
    private static final String URL =
            "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public ExchangeResponse buscarTaxas() {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            return gson.fromJson(response.body(), ExchangeResponse.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir API de câmbio");
        }
    }
}
