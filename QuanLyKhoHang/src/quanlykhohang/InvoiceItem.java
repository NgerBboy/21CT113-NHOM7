/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

public class InvoiceItem {
    private Product product;
    private int quantity;

    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return quantity * product.getPrice();
    }
    public double getTotalPrice() {
    return quantity * product.getPrice();
     }
    @Override
    public String toString() {
        return String.format("%-20s%-10d%-10.2f%-10.2f", product.getName(), quantity, product.getPrice(), getSubtotal());
    }
}
