/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

    private List<InvoiceItem> items;
    private double total;
    private LocalDate date;
    private String customerName;
    private String customerCode;
    private String address;
    private int phone;
    private String id;

    public Invoice(String customerName, String customerCode, String address, int phone, String id, LocalDate date) {
        this.items = new ArrayList<>();
        this.total = 0;
        this.date = date;
        this.customerName = customerName;
        this.customerCode = customerCode;
        this.address = address;
        this.phone = phone;
        this.id = id;
    }

    public void createInvoice(String customerName, LocalDate date, String customerCode, List<InvoiceItem> items) {
        Invoice invoice = new Invoice(customerName, customerCode, address, phone, id, date);
        //...
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (InvoiceItem item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
        total += item.getTotalPrice();
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

   

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append(" (").append(customerCode).append(")\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("address: ").append(address).append("\n");
        sb.append("phone: ").append(phone).append("\n");
        sb.append("id invoice: ").append(id).append("\n");
        sb.append("Items:\n");
        for (InvoiceItem item : items) {
            sb.append("- ").append(item.getProduct().getName()).append(": ").append(item.getQuantity())
                    .append(" x ").append(item.getProduct().getPrice()).append(" = ")
                    .append(item.getTotalPrice()).append("\n");
        }
        sb.append("Total: ").append(total);
        return sb.toString();
    }
}
