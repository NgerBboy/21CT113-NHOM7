/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    private String id;
    private String name;
    private String manufactureDate;
    private String expirationDate;
    private double price;
    int quantity;
    private String supplier;

    public Product(String id, String name, String manufactureDate, String expirationDate, double price, int quantity, String supplier) {
        this.id = id;
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;    
    }
    
}


