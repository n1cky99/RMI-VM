/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proiect;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockService extends Remote {
    void addProduct(String productName, double price, int quantity) throws RemoteException;
    boolean checkAvailability(String productName, int quantity) throws RemoteException;
    void placeOrder(String customerName, String[] orderDetails) throws RemoteException;
    void displayStock() throws RemoteException;
}
