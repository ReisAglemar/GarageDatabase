package edu.reis.garageDatabase.service;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Gemini implements Igemini {

    Gson gson = new Gson();
    private String geminiKey = System.getenv("GARAGE_DATABASE_KEY_GEMINI");
    private String link ="https://generativelanguage.googleapis.com/v1beta/models/" +
            "gemini-1.5-flash:generateContent?key=" + geminiKey;


    @Override
    public String getInfo(String brand, String name, String model, int year) {

        String jsonBody = """
                {
                        "contents": [{
                            "parts": [{
                                "text": "Faça uma breve descrição desse veiculo, lembre-se, queremos vender esse veículo: 
                                marca: %s, 
                                nome: %s, 
                                modelo: %s, 
                                ano: %d."
                            }]
                        }]
                    }
                """.formatted(brand, name, model, year);

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            RecordGemini record = gson.fromJson(response.body(), RecordGemini.class);
            return record.getText();
        } catch (Exception e){
            System.out.println("FAZER EXECPTION PERSONALIDAZA");
        }
        return "to do";
    }
}
