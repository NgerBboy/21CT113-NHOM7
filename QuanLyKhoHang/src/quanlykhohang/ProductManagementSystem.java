/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductManagementSystem {

    ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    private Inventory inventory;
    private Scanner scanner;

    public ProductManagementSystem() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("Product Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Products by Name");
            System.out.println("4. Search Products by Supplier");
            System.out.println("5. Search Products by Manufacture Date");
            System.out.println("6. Search Products by Expiration Date");
            System.out.println("7. Update Product Quantity");
            System.out.println("8. Save Inventory to File");
            System.out.println("9. Load Inventory from File");
            System.out.println("10. createInvoice");
            System.out.println("11. Calculate Revenue");
            System.out.println("12. saveInvoicesToFile");
            System.out.println("13. removeInvoice");
            System.out.println("14. calculateDailyRevenueByDate");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    searchProductsByName();
                    break;
                case 4:
                    searchProductsBySupplier();
                    break;
                case 5:
                    searchProductsByManufactureDate();
                    break;
                case 6:
                    searchProductsByExpirationDate();
                    break;
                case 7:
                    updateProductQuantity();
                    break;
                case 8:
                    saveInventoryToFile();
                    break;
                case 9:
                    loadInventoryFromFile();
                    break;
                case 10:
                    createInvoice();
                    break;
                case 11:
                    calculateRevenue();
                    break;
                case 12:
                    saveInvoicesToFile();
                    break;
                case 13:
                    removeInvoice();
                    break;
                case 14:
                    LocalDate date = LocalDate.now(); // Lấy ngày hiện tại
                    double revenue = calculateDailyRevenueByDate(date, invoices);
                    System.out.println("Daily revenue on " + date + ": " + revenue);
                    break;

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }

    private void addProduct() {
        System.out.println("Add Product");
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Manufacture Date: ");
        String manufactureDate = scanner.nextLine();
        System.out.print("Enter Product Expiration Date: ");
        String expirationDate = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Product Supplier: ");
        String supplier = scanner.nextLine();
        Product product = new Product(id, name, manufactureDate, expirationDate, price, quantity, supplier);
        inventory.addProduct(product);
        System.out.println("Product added.");
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    private void removeProduct() {
        System.out.println("Remove Product");
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        Iterator<Product> iterator = inventory.getProducts().iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void searchProductsByName() {
        System.out.println("Search Products by Name");
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.println("Search Results:");
        for (Product product : inventory.searchProductsByName(name)) {
            System.out.println(product);
        }
    }

    private void searchProductsBySupplier() {
        System.out.println("Search Products by Supplier");
        System.out.print("Enter Product Supplier: ");
        String supplier = scanner.nextLine();
        System.out.println("Search Results:");
        for (Product product : inventory.searchProductsBySupplier(supplier)) {
            System.out.println(product);
        }
    }

    private void searchProductsByManufactureDate() {
        System.out.println("Search Products by Manufacture Date");
        System.out.print("Enter Manufacture Date (in the format yyyy-MM-dd): ");
        String manufactureDate = scanner.nextLine();
        System.out.println("Search Results:");
        for (Product product : inventory.searchProductsByManufactureDate(manufactureDate)) {
            System.out.println(product);
        }
    }

    private void searchProductsByExpirationDate() {
        System.out.println("Search Products by Expiration Date");
        System.out.print("Enter Expiration Date (in the format yyyy-MM-dd): ");
        String expirationDate = scanner.nextLine();
        System.out.println("Search Results:");
        for (Product product : inventory.searchProductsByExpirationDate(expirationDate)) {
            System.out.println(product);
        }
    }

    private void updateProductQuantity() {
        System.out.println("Update Product Quantity");
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Quantity to add (positive) or remove (negative): ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        inventory.updateProductQuantity(id, quantity);
        System.out.println("Product quantity updated.");
    }

    private void saveInventoryToFile() {
        System.out.println("Save Inventory to File");
        System.out.print("Enter File Name: ");
        String fileName = "D:\\Week_11\\QuanLyKhoHang\\src\\quanlykhohang\\khohang.txt";
        inventory.saveToFile(fileName);
        System.out.println("Inventory saved to file.");
    }

    private void loadInventoryFromFile() {
        System.out.println("Load Inventory from File");
        System.out.print("Enter File Name: ");
        String fileName = "D:\\Week_11\\QuanLyKhoHang\\src\\quanlykhohang\\khohang.txt";
        inventory.loadFromFile(fileName);
        System.out.println("Inventory loaded from file.");
    }

    public void createInvoice() {
        System.out.println("Create Invoice");

        // Prompt user for customer name
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer code: ");
        String customerCode = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter id invoice: ");
        String id = scanner.nextLine();
        System.out.println("Enter phone: ");
        int phone = scanner.nextInt();
        scanner.nextLine(); // Đọc hết dòng và chuyển sang dòng tiếp theo
        // Create new invoice
        LocalDate date = LocalDate.now();
        Invoice invoice = new Invoice(customerName, customerCode, address, phone, id, date);

        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            // Search for product by name
            Product product = inventory.getProductByName(productName);
            if (product != null) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Đọc hết dòng và chuyển sang dòng tiếp theo

                // Check if there is enough stock
                if (product.getQuantity() >= quantity) {
                    InvoiceItem item = new InvoiceItem(product, quantity);
                    invoice.addItem(item);
                    product.setQuantity(product.getQuantity() - quantity);
                    System.out.println("Product added to invoice successfully.");
                } else {
                    System.out.println("Insufficient quantity. Please try again.");
                }
            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Add more products to invoice? (Y/N): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                addingProducts = false;
            }
        }

        // Add invoice to list of invoices
        invoices.add(invoice);
        System.out.println("Invoice created successfully.");
    }

    private void calculateRevenue() {
        double revenue = 0;
        for (Product product : inventory.getProducts()) {
            revenue += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total revenue: $" + revenue);
    }

    private void saveInvoicesToFile() {
        System.out.println("Save Invoices to File");
        System.out.print("Enter file name: ");
        String fileName = "D:\\Week_11\\QuanLyKhoHang\\src\\quanlykhohang\\dondathang.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(invoices.toString());
            writer.close();
            System.out.println("Invoices saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save invoices to file.");
            e.printStackTrace();
        }
    }

    public void removeInvoice() {
        System.out.println("Remove Invoice");
        System.out.print("Enter Invoice ID: ");
        String id = scanner.nextLine();

        boolean success = false;
        Iterator<Invoice> iterator = invoices.iterator();
        while (iterator.hasNext()) {
            Invoice invoice = iterator.next();
            if (invoice.getId().equals(id)) {
                // Return the product's quantity to inventory
                List<InvoiceItem> items = invoice.getItems();
                for (InvoiceItem item : items) {
                    Product product = item.getProduct();
                    int quantity = item.getQuantity();
                    product.setQuantity(product.getQuantity() + quantity);
                }
                iterator.remove(); // Remove the invoice
                success = true;
                break;
            }
        }

        if (success) {
            System.out.println("Invoice removed.");
        } else {
            System.out.println("Invoice not found.");
        }
    }

    public boolean removeInvoice(String customerCode) {
        Iterator<Invoice> iterator = invoices.iterator();
        while (iterator.hasNext()) {
            Invoice invoice = iterator.next();
            if (invoice.getCustomerCode().equals(customerCode)) {
                // Remove the invoice from the list
                iterator.remove();
                // Restore the product quantities
                for (InvoiceItem item : invoice.getItems()) {
                    Product product = item.getProduct();
                    product.setQuantity(product.getQuantity() + item.getQuantity());
                }
                return true;
            }
        }
        return false;
    }

    public double calculateDailyRevenueByDate(LocalDate date, List<Invoice> invoices) {
        double totalRevenue = 0.0;
        for (Invoice invoice : invoices) {
            if (invoice.getDate().equals(date)) {
                List<InvoiceItem> items = invoice.getItems();
                for (InvoiceItem item : items) {
                    totalRevenue += item.getProduct().getPrice() * item.getQuantity();
                }
            }
        }
        return totalRevenue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagementSystem system = new ProductManagementSystem();
        system.start();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);
        double dailyRevenue = system.calculateDailyRevenueByDate(date, system.getInvoices());
        System.out.println("Total revenue for " + date + ": $" + dailyRevenue);
    }

}
