package edu.reis.garageDatabase.service;

import com.google.gson.Gson;
import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Gemini implements Igemini {

    private String geminiKey = System.getenv("GARAGE_DATABASE_KEY_GEMINI");
    private String link = "https://generativelanguage.googleapis.com/v1beta/models/" +
            "gemini-1.5-flash:generateContent?key=" + geminiKey;
    Gson gson = new Gson();


    @Override
    public String getInfoVehicle(String brand, String name, String model, int year) throws ExceptionGemini, IOException, InterruptedException {
        String jsonBody = """
                {
                        "contents": [{
                            "parts": [{
                                "text": "Faça uma breve descrição(35 palavras) desse veiculo, lembre-se, queremos vender esse veículo: 
                                marca: %s, 
                                nome: %s, 
                                modelo: %s, 
                                ano: %d."
                            }]
                        }]
                    }
                """.formatted(brand, name, model, year);
        return getSearch(jsonBody);
    }

    @Override
    public String getInfoManufacturer(String name) throws ExceptionGemini, IOException, InterruptedException {
        String jsonBody = """
                {
                        "contents": [{
                            "parts": [{
                                "text": "Faça uma breve descrição(35 palavras) dessa fabricante de veículos: 
                                marca: %s"
                            }]
                        }]
                    }
                """.formatted(name);
        return getSearch(jsonBody);
    }

    //funcao auxiliar
    private String getSearch(String jsonBody) throws ExceptionGemini, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new ExceptionGemini("Erro ao consumir Gemini, Verifique sua conexão de dados!");
        }
        RecordGemini record = gson.fromJson(response.body(), RecordGemini.class);
        return record.getText();

    }
}
