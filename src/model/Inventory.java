package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //parts
    public static void addPart(Part newPart) {allParts.add(newPart);}

    //public static Part lookupPart(int partId){}

    //public static ObservableList<Part> lookupPart(String partName){}

    //public static void updatePart(int index, Part selectedPart){}

    //public static boolean deletePart(Part selectedPart){allParts.remove(selectedPart);}
    //how do I make above boolean?

    public static ObservableList<Part> getAllParts() {return allParts;}


   //products
    public static void addProduct(Product newProduct) {allProducts.add(newProduct);}

    //public static Product lookupProduct(int productId){}

    //public static ObservableList<Product> lookupProduct(String productName){}

    //public static void updateProduct(int index, Product newProduct){}

    //public static boolean deleteProduct(Product selectedProduct){allProducts.remove(selectedProduct);}
    //how do I make above boolean?

    public static ObservableList<Product> getAllProducts() {return allProducts;}

}
