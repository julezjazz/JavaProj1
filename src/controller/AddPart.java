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

public class AddPart implements Initializable {

    public Label toggleLabel;
    public RadioButton inHouse;
    public RadioButton outsourced;

    public Label warningLabel;

    public TextField nameTF;
    public TextField stockTF;
    public TextField priceTF;
    public TextField maxTF;
    public TextField minTF;
    public TextField toggleTF;

    public Inventory inventory;

    public static int autoId = 101;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void onOutsourced(ActionEvent actionEvent) {
        toggleLabel.setText("Company Name");
    }

    public void onInHouse(ActionEvent actionEvent) {
        toggleLabel.setText("Machine ID");
    }


    public void onSaveButton(ActionEvent actionEvent) throws IOException {

        autoId += 2;

        warningLabel.setText("");

        try {

            if (nameTF.getText() == "") {
              warningLabel.setText("Please enter valid values in text fields");
            } else if (Integer.parseInt(minTF.getText()) >= Integer.parseInt(maxTF.getText())) {
                warningLabel.setText("Min must be less than max");
            } else if (Integer.parseInt(minTF.getText()) > Integer.parseInt(stockTF.getText())) {
                warningLabel.setText("Inventory level must be greater than or equal to min");
            } else if (Integer.parseInt(maxTF.getText()) < Integer.parseInt(stockTF.getText())) {
                warningLabel.setText("Inventory level must be less than or equal to max");
            } else if (inHouse.isSelected()) {
                InHouse iH = new InHouse(autoId, nameTF.getText(), Double.parseDouble(priceTF.getText()),
                        Integer.parseInt(stockTF.getText()), Integer.parseInt(minTF.getText()),
                        Integer.parseInt(maxTF.getText()), Integer.parseInt(toggleTF.getText()));

                inventory.addPart(iH);

                Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 850, 750);
                stage.setTitle("Inventory Management");
                stage.setScene(scene);
                stage.show();
            } else {
                Outsourced oS = new Outsourced(autoId, nameTF.getText(), Double.parseDouble(priceTF.getText()),
                        Integer.parseInt(stockTF.getText()), Integer.parseInt(minTF.getText()),
                        Integer.parseInt(maxTF.getText()), toggleTF.getText());

                inventory.addPart(oS);

                Parent root = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 850, 750);
                stage.setTitle("Inventory Management");
                stage.setScene(scene);
                stage.show();
            }
        }
        catch (NumberFormatException e)
        {
            warningLabel.setText("Please enter valid values in text fields");
        }


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
