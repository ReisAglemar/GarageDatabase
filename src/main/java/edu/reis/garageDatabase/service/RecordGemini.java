package edu.reis.garageDatabase.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record RecordGemini(@SerializedName("candidates") List<Candidate> candidates) {

    public record Candidate(@SerializedName("content") Content content) {}
    public record Content(@SerializedName("parts") List<Part> parts) {}
    public record Part(@SerializedName("text") String text){}

    public String getText() {
        String text = candidates.stream()
                .map(Candidate::content)
                .flatMap(c -> c.parts.stream())
                .map(Part::text)
                .findFirst()
                .orElse("Erro ao tratar resposta");
        return text;
    }
}
