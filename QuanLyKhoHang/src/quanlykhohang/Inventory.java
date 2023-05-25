/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

/**
 *
 * @author hoang
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(String id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    

    public Product getProductById(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return products.get(i);
            }
        }
        return null;
    }

    public ArrayList<Product> searchProductsByName(String name) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                result.add(products.get(i));
            }
        }
        return result;
    }

    public ArrayList<Product> searchProductsBySupplier(String supplier) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getSupplier().equals(supplier)) {
                result.add(products.get(i));
            }
        }
        return result;
    }

    public ArrayList<Product> searchProductsByManufactureDate(String date) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getManufactureDate().equals(date)) {
                result.add(products.get(i));
            }
        }
        return result;
    }

    public ArrayList<Product> searchProductsByExpirationDate(String date) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getExpirationDate().equals(date)) {
                result.add(products.get(i));
            }
        }
        return result;
    }

    public void saveToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < products.size(); i++) {
                writer.write(products.get(i).getId() + ",");
                writer.write(products.get(i).getName() + ",");
                writer.write(products.get(i).getManufactureDate() + ",");
                writer.write(products.get(i).getExpirationDate() + ",");
                writer.write(products.get(i).getPrice() + ",");
                writer.write(products.get(i).getQuantity() + ",");
                writer.write(products.get(i).getSupplier());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file.");
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    String id = fields[0];
                    String name = fields[1];
                    String manufactureDate = fields[2];
                    String expirationDate = fields[3];
                    double price = Double.parseDouble(fields[4]);
                    int quantity = Integer.parseInt(fields[5]);
                    String supplier = fields[6];
                    Product product = new Product(id, name, manufactureDate, expirationDate, price, quantity, supplier);
                    addProduct(product);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + fileName + " does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }
//    public void loadFromFile(String fileName) {
//        try {
//            Scanner scanner = new Scanner(new File(fileName));
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] fields = line.split(",");
//                if (fields.length == 7) {
//                    String id = fields[0];
//                    String name = fields[1];
//                    String manufactureDate = fields[2];
//                    String expirationDate = fields[3];
//                    double price = Double.parseDouble(fields[4]);
//                    int quantity = Integer.parseInt(fields[5]);
//                    String supplier = fields[6];
//                    Product product = new Product(id, name, manufactureDate, expirationDate, price, quantity, supplier);
//                    addProduct(product);
//                }
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("The file " + fileName + " does not exist.");
//            e.printStackTrace();
//        }
//    }

    public void updateProductQuantity(String id, int quantity) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.get(i).quantity = quantity;
                break;
            }
        }
    }

    public void loadInventoryFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            String id = line[0];
            String name = line[1];
            String manufactureDate = line[2];
            String expirationDate = line[3];
            double price = Double.parseDouble(line[4]);
            int quantity = Integer.parseInt(line[5]);
            String supplier = line[6];
            Product product = new Product(id, name, manufactureDate, expirationDate, price, quantity, supplier);
            addProduct(product);
        }
        scanner.close();
    }

    public void saveInventoryToFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        for (Product product : products) {
            String line = product.getId() + "," + product.getName() + "," + product.getManufactureDate() + "," + product.getExpirationDate() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getSupplier() + "\n";
            writer.write(line);
        }
        writer.close();
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
    //...

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

}
