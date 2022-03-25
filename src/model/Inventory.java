package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //parts
    public static void addPart(Part newPart) {allParts.add(newPart);}

    public static Part lookupPart(int partId){
        for (Part part : allParts){
            if(part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> namedParts = FXCollections.observableArrayList();

        for (Part part : allParts) {
            if (part.getName().contains(partName)) {
                namedParts.add(part);
            }
        }
        return namedParts;
    }

    //public static void updatePart(int index, Part selectedPart){}

    public static boolean deletePart(Part selectedPart){
        if(selectedPart == null)
            return false;
        allParts.remove(selectedPart);
        return true;
    }


    public static ObservableList<Part> getAllParts() {return allParts;}


   //products
    public static void addProduct(Product newProduct) {allProducts.add(newProduct);}

    //public static Product lookupProduct(int productId){}

    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> namedProducts = FXCollections.observableArrayList();
        for (Product product : allProducts) {
            if (product.getName().contains(productName)) {
                namedProducts.add(product);
            }
        }
        return namedProducts;
    }

    //public static void updateProduct(int index, Product newProduct){}

    public static boolean deleteProduct(Product selectedProduct){
        if(selectedProduct == null)
            return false;
        allProducts.remove(selectedProduct);
        return true;
    }

    public static ObservableList<Product> getAllProducts() {return allProducts;}

    //Test Data Below
    static {
       addTestData();
    }

    public static void addTestData(){
        InHouse inHouse1 = new InHouse(111,"Part abc", 4,3, 1, 4, 123);
        InHouse inHouse2 = new InHouse(121, "Part abd", 6, 4, 1, 5, 321);
        Outsourced outsourced1 = new Outsourced(444, "Part 444", 14, 2, 2, 5, "MT");
        Outsourced outsourced2 = new Outsourced(142, "Part 4", 16, 3, 2, 5, "TM");

        allParts.add(inHouse1);
        allParts.add(inHouse2);
        allParts.add(outsourced1);
        allParts.add(outsourced2);

        Product product1 = new Product(11, "Product cde", 22, 2, 1, 4);
        Product product2 = new Product(12, "Product cdf", 17, 1, 1, 5);

        allProducts.add(product1);
        allProducts.add(product2);

    }

}
