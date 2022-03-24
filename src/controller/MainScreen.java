package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;

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
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Add Part");
        stage.setScene(scene);
        stage.show();
    }

    public void onModifyPart(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Modify Part");
        stage.setScene(scene);
        stage.show();
    }

    public void onAddProduct(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
    }

    public void onModifyProduct(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
    }

    public void onDeletePart(ActionEvent actionEvent) {
        Part SPart = (Part)partsTable.getSelectionModel().getSelectedItem();

        inventory.deletePart(SPart);

    }
}
