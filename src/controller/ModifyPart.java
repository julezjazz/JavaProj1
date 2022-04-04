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
/** This class is the controller for the ModifyPart.fxml page for the Modify Part scene. */
public class ModifyPart implements Initializable {

    public Label toggleLabel;
    public RadioButton inHouse;
    public RadioButton outsourced;

    public Label warningLabel;

    public TextField idTF2;
    public TextField nameTF2;
    public TextField stockTF2;
    public TextField priceTF2;
    public TextField maxTF2;
    public TextField minTF2;
    public TextField toggleTF2;
    /** This causes the text fields to populate based on which part was selected to modify in the previous screen. It
     * also causes the radio button and toggle label to be selected based on which types of part is being modified. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (partTypeIH == true) {
            inHouse.setSelected(true);
            idTF2.setText(Integer.toString(ihPartToModify.getId()));
            nameTF2.setText(ihPartToModify.getName());
            stockTF2.setText(Integer.toString(ihPartToModify.getStock()));
            priceTF2.setText(Double.toString(ihPartToModify.getPrice()));
            maxTF2.setText(Integer.toString(ihPartToModify.getMax()));
            minTF2.setText(Integer.toString(ihPartToModify.getMax()));
            toggleTF2.setText(Integer.toString(ihPartToModify.getMachineId()));
        }
        else {
            outsourced.setSelected(true);
            toggleLabel.setText("Company Name");
            idTF2.setText(Integer.toString(osPartToModify.getId()));
            nameTF2.setText(osPartToModify.getName());
            stockTF2.setText(Integer.toString(osPartToModify.getStock()));
            priceTF2.setText(Double.toString(osPartToModify.getPrice()));
            maxTF2.setText(Integer.toString(osPartToModify.getMax()));
            minTF2.setText(Integer.toString(osPartToModify.getMax()));
            toggleTF2.setText(osPartToModify.getCompanyName());
        }

    }

    /** This changes the toggle label to say "Machine ID" when the InHouse button is selected. */
    public void onInHouse(ActionEvent actionEvent) {
        toggleLabel.setText("Machine ID");
    }
    /** This changes the toggle label to say "Company Name" when the Outsourced button is selected. */
    public void onOutsourced(ActionEvent actionEvent)  {
        toggleLabel.setText("Company Name");
    }
    /** This saves changes made to the part being modified and returns to the Main Screen. */
    public void onSaveButton(ActionEvent actionEvent) throws IOException {
        warningLabel.setText("");

        try {
            if (nameTF2.getText() == "") {
                warningLabel.setText("Please enter valid values in text fields");
            } else if (Integer.parseInt(minTF2.getText()) >= Integer.parseInt(maxTF2.getText())) {
                warningLabel.setText("Min must be less than max");
            } else if (Integer.parseInt(minTF2.getText()) > Integer.parseInt(stockTF2.getText())) {
                warningLabel.setText("Inventory level must be greater than or equal to min");
            } else if (Integer.parseInt(maxTF2.getText()) < Integer.parseInt(stockTF2.getText())) {
                warningLabel.setText("Inventory level must be less than or equal to max");
            } else if (partTypeIH == true) {
                ihPartToModify.setName(nameTF2.getText());
                ihPartToModify.setStock(Integer.parseInt(stockTF2.getText()));
                ihPartToModify.setPrice(Double.parseDouble(priceTF2.getText()));
                ihPartToModify.setMax(Integer.parseInt(maxTF2.getText()));
                ihPartToModify.setMin(Integer.parseInt(minTF2.getText()));
                ihPartToModify.setMachineId(Integer.parseInt(toggleTF2.getText()));

                Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 850, 750);
                stage.setTitle("Inventory Management");
                stage.setScene(scene);
                stage.show();
            } else {
                osPartToModify.setName(nameTF2.getText());
                osPartToModify.setStock(Integer.parseInt(stockTF2.getText()));
                osPartToModify.setPrice(Double.parseDouble(priceTF2.getText()));
                osPartToModify.setMax(Integer.parseInt(maxTF2.getText()));
                osPartToModify.setMin(Integer.parseInt(minTF2.getText()));
                osPartToModify.setCompanyName(toggleTF2.getText());

                Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 850, 750);
                stage.setTitle("Inventory Management");
                stage.setScene(scene);
                stage.show();
            }
        }
        catch (NumberFormatException e){
            warningLabel.setText("Please enter valid values in text fields");
        }
    }
    /** Without saving changes, this returns to the Main Screen. */
    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 750);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
}
