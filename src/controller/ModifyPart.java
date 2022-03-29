package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.MainScreen.*;

public class ModifyPart implements Initializable {

    public Label toggleLabel;
    public RadioButton inHouse;
    public RadioButton outsourced;

    public TextField idTF2;
    public TextField nameTF2;
    public TextField stockTF2;
    public TextField priceTF2;
    public TextField maxTF2;
    public TextField minTF2;
    public TextField toggleTF2;

    public Inventory inventory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (partTypeIH == true) {
            idTF2.setText(Integer.toString(ihPartToModify.getId()));
            nameTF2.setText(ihPartToModify.getName());
            stockTF2.setText(Integer.toString(ihPartToModify.getStock()));
            priceTF2.setText(Double.toString(ihPartToModify.getPrice()));
            maxTF2.setText(Integer.toString(ihPartToModify.getMax()));
            minTF2.setText(Integer.toString(ihPartToModify.getMax()));
            toggleTF2.setText(Integer.toString(ihPartToModify.getMachineId()));
        }
        else {
            idTF2.setText(Integer.toString(osPartToModify.getId()));
            nameTF2.setText(osPartToModify.getName());
            stockTF2.setText(Integer.toString(osPartToModify.getStock()));
            priceTF2.setText(Double.toString(osPartToModify.getPrice()));
            maxTF2.setText(Integer.toString(osPartToModify.getMax()));
            minTF2.setText(Integer.toString(osPartToModify.getMax()));
            toggleTF2.setText(osPartToModify.getCompanyName());
        }

    }

    public void onInHouse(ActionEvent actionEvent) {
        toggleLabel.setText("Machine ID");
    }

    public void onOutsourced(ActionEvent actionEvent)  {
        toggleLabel.setText("Company Name");
    }

    public void onSaveButton(ActionEvent actionEvent) {

    }

    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 750);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
}
