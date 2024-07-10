/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proiect;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProiectClient {
    public static void main(String[] args) {
        try {
            // Obține referința la registrul RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obține referința la serviciul StockService din registrul RMI
            StockService stockService = (StockService) registry.lookup("StockService");

            // Utilizarea serviciului RMI pentru a executa instrucțiunile
            stockService.addProduct("Laptop", 2500, 10);
            stockService.addProduct("Telefon", 1500, 20);
            boolean availableLaptop = stockService.checkAvailability("Laptop", 3);
            boolean availablePhone = stockService.checkAvailability("Telefon", 25);
            System.out.println("Disponibilitate Laptop: " + availableLaptop);
            System.out.println("Disponibilitate Telefon: " + availablePhone);
            
            // Plasarea unei comenzi
            String[] orderDetails = {"Laptop", "2", "Telefon", "5"};
            stockService.placeOrder("John_Doe", orderDetails);
            
            // Afișarea stocului actualizat
            stockService.displayStock();

        } catch (Exception e) {
            System.err.println("Eroare la conectarea la serverul RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}