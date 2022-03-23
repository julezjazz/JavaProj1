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

    //Test Data Below
    static {
       addTestData();
    }

    public static void addTestData(){
        InHouse inHouse1 = new InHouse(1,"Part One", 4,3, 1, 4, 123);
        InHouse inHouse2 = new InHouse(2, "Part Two", 6, 4, 1, 5, 321);
        Outsourced outsourced1 = new Outsourced(3, "Part 3", 14, 2, 2, 5, "MT");
        Outsourced outsourced2 = new Outsourced(4, "Part 4", 16, 3, 2, 5, "TM");

        allParts.add(inHouse1);
        allParts.add(inHouse2);
        allParts.add(outsourced1);
        allParts.add(outsourced2);

        Product product1 = new Product(11, "Product One", 22, 2, 1, 4);
        Product product2 = new Product(12, "Product 2", 17, 1, 1, 5);

        allProducts.add(product1);
        allProducts.add(product2);

    }

}
