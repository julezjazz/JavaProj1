package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {

    public Button addPart;
    public Button modifyPart;
    public Button deletePart;

    public Button addProduct;
    public Button modifyProduct;
    public Button deleteProduct;

    public TableView partsTable;
    public TableView productsTable;

    public TableColumn partIdCol;
    public TableColumn partNameCol;
    public TableColumn partInvLevelCol;
    public TableColumn partPriceCol;

    public TableColumn productIdCol;
    public TableColumn productNameCol;
    public TableColumn productInvLevelCol;
    public TableColumn productPriceCol;

    public DialogPane dialogPane;
    public TextField searchBarPart;
    public TextField searchBarProduct;

    public Inventory inventory;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsTable.setItems(inventory.getAllParts());
        productsTable.setItems(inventory.getAllProducts());

        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

    public void onAddPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Add Part");
        stage.setScene(scene);
        stage.show();
    }

    public void onModifyPart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Modify Part");
        stage.setScene(scene);
        stage.show();
    }

    public void onDeletePart(ActionEvent actionEvent) {
        Part SPart = (Part) partsTable.getSelectionModel().getSelectedItem();
        inventory.deletePart(SPart);
        if (inventory.deletePart(SPart) == false) {
            dialogPane.setContentText("Invalid Selection");
        } else {
            dialogPane.setContentText("");
        }
    }

    public void onAddProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
    }

    public void onModifyProduct(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
    }

    public void onDeleteProduct(ActionEvent actionEvent) {
        Product SProduct = (Product) productsTable.getSelectionModel().getSelectedItem();
        inventory.deleteProduct(SProduct);
        if (inventory.deleteProduct(SProduct) == false) {
            dialogPane.setContentText("Invalid Selection");
        } else {
            dialogPane.setContentText("");
        }
    }


    public void getResultsParts(ActionEvent actionEvent) {
        String s = searchBarPart.getText();

        ObservableList<Part> parts = inventory.lookupPart(s);

        partsTable.setItems(parts);
        searchBarPart.setText("");

        if (parts.size() == 0) {

           int id = Integer.parseInt(s);
           Part part = inventory.lookupPart(id);
           if (part != null)
              parts.add(part);
           }
    }

    public void getResultsProducts(ActionEvent actionEvent){
        String s = searchBarProduct.getText();

        ObservableList<Product> products = inventory.lookupProduct(s);
        productsTable.setItems(products);
        searchBarProduct.setText("");

        if (products.size() == 0) {
            int id = Integer.parseInt(s);
            Product product = inventory.lookupProduct(id);
            if (product != null)
                products.add(product);
        }
    }







}








