/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

public class Transaction {
    private String id;
    private String date;
    private Product product;
    public int quantity;
    private double price;

    public Transaction(String id, String date, Product product, int quantity, double price) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
