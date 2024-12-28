package edu.reis.garageDatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfig {

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
