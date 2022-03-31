package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** This class is used to set up the structure of Product Objects. */
public class Product {

    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    /** This is the constructor for Product objects. */
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }
    /** This returns the ID for a Product object. */
    public int getId() {return id;}
    /** This sets the ID for a Product object. */
    public void setId(int id) {this.id = id;}
    /** This returns the name for a Product object. */
    public String getName() {return name;}
    /** This sets the name for a Product object. */
    public void setName(String name) {this.name = name;}
    /** This returns the price for a Product object. */
    public double getPrice() {return price;}
    /** This sets the price for a Product object. */
    public void setPrice(double price) {this.price = price;}
    /** This returns the stock for a Product object. */
    public int getStock() {return stock;}
    /** This sets the stock for a Product object. */
    public void setStock(int stock) {this.stock = stock;}
    /** This returns the minimum for a Product object. */
    public int getMin() {return min;}
    /** This sets the minimum for a Product object. */
    public void setMin(int min) {this.min = min;}
    /** This returns the maximum for a Product object. */
    public int getMax() {return max;}
    /** This sets the maximum for a Product object. */
    public void setMax(int max) {this.max = max;}
    /** This adds a part to the list of associated parts for a Product object. */
   public void addAssociatedPart(Part part) {associatedParts.add(part);}
    /** This deletes a part from list of associated parts for a Product object and returns true, or if it is
     * unable to delete the part, it returns false. */
   public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        if(selectedAssociatedPart == null)
            return false;
        associatedParts.remove(selectedAssociatedPart);
        return true;
    }
    /** This returns the list of associated parts for a Product object. */
   public ObservableList<Part> getAllAssociatedParts() {return associatedParts;}
}
