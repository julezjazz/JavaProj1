package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
}
