/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proiect;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class StockServiceImpl extends UnicastRemoteObject implements StockService {
    private Map<String, Integer> stock;

    public StockServiceImpl() throws RemoteException {
        super();
        this.stock = new HashMap<>();
    }

    public void addProduct(String productName, double price, int quantity) throws RemoteException {
        if (quantity < 0) {
            System.out.println("Cantitatea trebuie sa fie pozitiva.");
            return;
        }
        stock.put(productName, quantity);
        System.out.println("Produs adaugat in stoc: " + productName + ", pret: " + price + " lei, cantitate: " + quantity);
    }

    public boolean checkAvailability(String productName, int quantity) throws RemoteException {
        int availableQuantity = stock.getOrDefault(productName, 0);
        return availableQuantity >= quantity;
    }

    public void placeOrder(String customerName, String[] orderDetails) throws RemoteException {
        System.out.println("Comanda plasata de catre " + customerName + ":");
        for (int i = 0; i < orderDetails.length; i += 2) {
            String productName = orderDetails[i];
            int quantity = Integer.parseInt(orderDetails[i + 1]);
            int availableQuantity = stock.getOrDefault(productName, 0);
            if (availableQuantity >= quantity) {
                System.out.println("- " + productName + ": " + quantity);
                stock.put(productName, availableQuantity - quantity);
            } else {
                System.out.println("Stoc insuficient pentru produsul " + productName + ".");
            }
        }
    }

    public void displayStock() throws RemoteException {
        System.out.println("Stoc:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
