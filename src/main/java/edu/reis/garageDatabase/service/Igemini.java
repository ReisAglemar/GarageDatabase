package edu.reis.garageDatabase.service;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;

import java.io.IOException;

public interface Igemini {
    String getInfoVehicle(String brand, String name, String model, int year) throws ExceptionGemini, IOException, InterruptedException;

    String getInfoManufacturer(String name) throws ExceptionGemini, IOException, InterruptedException;
}
