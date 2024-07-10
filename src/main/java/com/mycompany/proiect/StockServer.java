/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proiect;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StockServer {
    public static void main(String[] args) {
        try {
            StockService stockService = new StockServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StockService", stockService);
            System.out.println("Serverul RMI este pornit...");
        } catch (Exception e) {
            System.err.println("Eroare la pornirea serverului RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

